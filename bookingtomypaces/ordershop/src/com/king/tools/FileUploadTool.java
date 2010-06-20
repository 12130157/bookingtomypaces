/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileUploadTool {
	
	/**
     * 更换文件名称防止重名
     * @param fileName
     * @return
     */
public static String generateFileName(String fileName) {    
    DateFormat format = new SimpleDateFormat("yyMMddHHmmss");  
    String formatDate = format.format(new Date());  //取得  当前时间  
        
    int random = new Random().nextInt(10000);  //定义一个随机数  
        
    int position = fileName.lastIndexOf("."); 
    String extension = fileName.substring(position);   //提取后缀名   
        
    return formatDate + random + extension;    //返回更改后的随机的文件名
	}  
}
