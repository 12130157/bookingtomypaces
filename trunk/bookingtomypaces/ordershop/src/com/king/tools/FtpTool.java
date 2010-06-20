/**
 * 文件服务器工具类。文件按类存放，比如web上传的动态图片（images），普通的文档（如doc、excel等）
 * images需要在web页面上显示，所以单独做为一类，ftp服务器需要与web服务器安装在同一台物理机器上
 * 注意：
 * 1、每个分类在ftp服务器上必须是根路径；
 * 2、上传的文件按照年、月、日自动建目录，文件名前面增加当前系统时间字符串"1242705577390_"
 *    例如：1242705577390_jetty.log
 * 3、uploadFile方法传回文件保存的url。
 * ==============================
 * 已经在iis、Serv-U（Window）、vsftp（linux）上进行过测试。
 */
package com.king.tools;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.king.common.exception.KINGException;

import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

public class FtpTool implements InitializingBean {
	
	private  FtpClient ftpClient;
	private  String server;
	private  int port = 21;
	private  String user;
	private  String password;	
	private  String rootPath;	
	
	private  String year = null;
	private  String month = null;
	private  String day = null;
	private  String hour = null;
	private  String fName = null;
	
	public FtpTool(){
	}
	
	public FtpTool(String server, int port,String user, String password,String rootPath) throws KINGException {
		this.server = server;
		this.user = user;
		this.password = password;
		this.rootPath = rootPath;
		this.port = port;
		this.initClient();
	}
	
	/**
	 * 连接ftp服务器
	 * @throws KINGException
	 */
	public void initClient() throws KINGException{
		// 连接ftp服务器
		try {
			ftpClient = new FtpClient();
			ftpClient.openServer(server,port);
			ftpClient.login(user, password);
			if(rootPath!=null && rootPath.length() > 1){
				rootPath.replace('\\', '/');
				StringTokenizer s = new StringTokenizer(rootPath, "/"); 
		        while (s.hasMoreElements()) {
		        	this.cdMkDir((String) s.nextElement());		
		        }
			}
		} catch (IOException e) {
			e.printStackTrace();
			KINGException ee = new KINGException("open_ftp_server_error",e);
			throw ee;
		}
	}
	
	/**
	 * 如果给定文件名url，而不是InputStream，需要自己构造FileInputStream
	 * @param fileName
	 * @return
	 * @throws KINGException
	 */
	private InputStream readFile(String fileName)  throws KINGException{
		java.io.File file_in = new java.io.File(fileName);
		if (!file_in.exists() && file_in.length() == 0) {
			return null;
		}
		InputStream in;
		try {
			in = new FileInputStream(file_in);
		} catch (FileNotFoundException e) {
			KINGException ee = new KINGException("ftp_server_read_file_error");
			throw ee;
		}
		return  in;

	}
	
	
	/**
	 * 按照年月日生成文件保存目录，文件名前面增加系统时间，来保证文件名不会重复
	 * @param filename
	 */
	private void createFileName(String filename){
		Long time = System.currentTimeMillis();
		fName = time + "_" + filename;
		createDateDir();
	}
	
	private void createDateDir(){
		Calendar cal = Calendar.getInstance();
		Long time = System.currentTimeMillis();
		cal.setTimeInMillis(time);
		year = String.valueOf(cal.get(Calendar.YEAR));
		month = String.valueOf(cal.get(Calendar.MONTH)+1);
		day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		hour = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
		
		if(month.length() == 1){
			month = "0" + month;
		}
		
		if(day.length() == 1){
			day = "0" + day;
		}
		
		if(hour.length() == 1){
			hour = "0" + hour;
		}
	}
	
	/**
	 * 当文件已经保存在调用者磁盘上时使用此方法，url为绝对路径.全部采用二进制方式传送文件
	 * @param url：文件绝对路径
	 * @return 返回ftp上的路径
	 * @throws KINGException
	 */
	public String uploadeFaxFile ( String url) throws KINGException{
		url = url.replace('\\', '/');
		InputStream in = readFile(url);
		String fileName = url.substring(url.lastIndexOf("/")+1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		fileName = sdf.format(cal.getTime()) + "_" + fileName;
		
		if(!ftpClient.serverIsOpen()){
			KINGException ee = new KINGException("ftp_server_not_open");
			throw ee;
		}
		TelnetOutputStream os = null;
		try {
			createDateDir();
			this.cdMkDir(this.year);
			this.cdMkDir(this.month);
			this.cdMkDir(this.day);
			this.cdMkDir(this.hour);
			ftpClient.binary(); //用2进制上传
			os = ftpClient.put(fileName);
			byte[] bytes = new byte[1024];
			int c = 0;
			while ((c = in.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
		} catch (Exception e) {
			KINGException ee = new KINGException("ftp_upload_error",e);
			throw ee;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(this.rootPath == null || this.rootPath.length() == 0 || this.rootPath.equalsIgnoreCase("/")){
			return "/" + year + "/" + month + "/" + day + "/" + fileName;
		}else{
			return "/" + this.rootPath + "/" + year + "/" + month + "/" + day + "/" + fileName;
		}
	}	
	
	/**
	 * 当文件已经保存在调用者磁盘上时使用此方法，url为绝对路径.全部采用二进制方式传送文件
	 * @param url：文件绝对路径
	 * @return 返回ftp上的路径
	 * @throws KINGException
	 */
	public String uploadeFile ( String url) throws KINGException{
		url = url.replace('\\', '/');
		InputStream in = readFile(url);
		String fileName = url.substring(url.lastIndexOf("/")+1);
		String path = uploadeFile(in,fileName);
		return path;
	}	
	/**
	 * 给定输入流，直接保存到ftp服务器，全部采用二进制方式传送文件
	 * @param in  要保存的文件的输入流
	 * @param fileName 要保存的文件名，不能为空，至少要给一个后缀名（例如.doc）
	 * @return
	 * @throws KINGException
	 */
	public String uploadeFile ( InputStream in, String shortName) throws KINGException{
		TelnetOutputStream os = null;
		String fullFileName = null;
		if(!ftpClient.serverIsOpen()){
			KINGException ee = new KINGException("ftp_server_not_open");
			throw ee;
		}
		createFileName(shortName);
		try {
			this.cdMkDir(this.year);
			this.cdMkDir(this.month);
			this.cdMkDir(this.day);
			ftpClient.binary(); //用2进制上传
			os = ftpClient.put(this.fName);
			byte[] bytes = new byte[1024];
			int c = 0;
			while ((c = in.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
//			fullFileName = "/" + this.rootPath + "/" + year + "/" + month + "/" + day + "/" + fName;
			if(this.rootPath == null || this.rootPath.length() == 0 || this.rootPath.equalsIgnoreCase("/")){
				return "/" + year + "/" + month + "/" + day + "/" + fName;
			}else{
				return "/" + this.rootPath + "/" + year + "/" + month + "/" + day + "/" + fName;
			}
		} catch (Exception e) {
			KINGException ee = new KINGException("ftp_upload_error",e);
			throw ee;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 给定ftp路径，输出给定文件。
	 * @param url
	 * @param outFileName  需要取ftp服务器上读取的文件的文件名，包括路径名
	 *        例如：/2009/05/12/1242143343406_jetty.log
	 * @throws KINGException 抛出code为"ftp_output_open_filestream_error"
	 *         或者"ftp_output_read_files_error"的异常
	 */
	public void getFile(String url,String outFileName) throws KINGException{
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(outFileName);
		} catch (FileNotFoundException e) {
			KINGException ee = new KINGException("ftp_output_open_filestream_error",e);
			throw ee;
		}
		getFile(url,os);
	}	
	/**
	 * 给定ftp路径，输出文件到已经打开的输出流中，并且关闭输出流
	 * @param url
	 * @param os  用户指定的输出流，从ftp出文件直接放入输出流
	 * @throws KINGException 
	 */
	public void getFile(String url,OutputStream os) throws KINGException{
		InputStream in = null;
		try {
			in = ftpClient.get(url);
			byte[] bytes = new byte[1024];
			int c = 0;
			while ((c = in.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
		} catch (IOException e) {
			e.printStackTrace();
			KINGException ee = new KINGException("ftp_output_read_files_error",e);
			throw ee;
		}finally{
			try {
				if(os != null)
					os.close();
				if(in != null)
					in.close();
			} catch (IOException e) {
			}
		}
	}

	
	/**
	 * 删除指定目录下的文件
	 * @param fileName 完整文件名，包含目录。如：/images/2009/05/20/20090620121212123.jpg
	 * @throws KINGException 
	 */
	public void deleteFile(String fileName) throws KINGException{
//		String fName = fileName.replaceAll("\\", "/");
		try {
			ftpClient.sendServer("dele /" + fileName + "\r\n");
		} catch (RuntimeException e) {
			throw new KINGException("ftp_rm_file_error",e);
		}
	}
	
	
	/**
	 * 进入给定目录，如果不存在则创建
	 * @param path 如果目录不存在则自动建
	 * @throws KINGException 
	 */
	private void cdMkDir(String path) throws KINGException{
		try {
			ftpClient.cd(path);
		} catch (Exception e) {
			if(e.getMessage().indexOf("No such file or directory")>0
					|| e.getMessage().indexOf(" 550 ")>0){
				if(!this.Mkdir(path)){
					throw new KINGException("ftp_mkdir_error",e);
				}
				try {
					ftpClient.cd(path);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}	
	}

	/**
	 * ftp cd 命令
	 * @param path 跳转的目录名
	 * @throws KINGException
	 */
	public void cd(String path) throws KINGException{
		try {
			ftpClient.cd(path);
		} catch (Exception e) {
			e.printStackTrace();
			throw new KINGException("ftp_cd_error",e);
		}	
	}
	
	
	/**
	 * 在ftp服务器上新建目录
	 * @param path 需要建的目录名
	 * @return
	 * @throws KINGException 
	 */
	private boolean Mkdir(String path) throws KINGException{
        try {     
			ftpClient.sendServer("XMKD " + path + "\r\n");           
			int reply = ftpClient.readServerResponse();
			if(reply>199 && reply<300){
				System.out.println("ftp mkdir return code:" + reply);
				return true;
			}
		} catch (IOException e) {
			KINGException ee = new KINGException("ftp_mkdir_io_error",e);
			throw ee;
		}
		return false;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void afterPropertiesSet() throws KINGException {
		this.initClient();
	}
	
	public void closeServer(){
		try {
			if (ftpClient != null) {
				ftpClient.closeServer();
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
	        ClassPathXmlApplicationContext context 
            	= new ClassPathXmlApplicationContext("com/king/tools/applicationContext-ftp.xml");

	        FtpTool ftp = (FtpTool)context.getBean("imageFtp");

//			FtpUtil ftp = new FtpUtil("10.124.20.22","ftpuser","kinguser","images");
			String fileUrl = ftp.uploadeFile("d:/jetty.log");
//			ftp.cd("");
	        
//	        String fileUrl = "/images/2009/06/09/1244537318890_jetty.log";
			System.out.println("fileUrl:" + fileUrl);
			ftp.deleteFile(fileUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
