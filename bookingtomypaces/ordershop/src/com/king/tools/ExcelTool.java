/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.tools;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;


public class ExcelTool {
	public ExcelTool() {
	}

	/**
	 * ��ȡExcel
	 * 读取excel文件
	 * @param filePath
	 */
	public static List<List> readExcel(String filePath) {
		
		List<List> sheetList=new ArrayList<List>();//取得整个xls各个sheet中的总数据
		try {
			InputStream is = new FileInputStream(filePath);
			Workbook rwb = Workbook.getWorkbook(is);
			Sheet[] sheets=rwb.getSheets();
			
			for(int i=0;i<sheets.length-1;i++){//取得表中sheet的个数
				List<List> allLineList=new  ArrayList<List>();//取得一个sheet中n行的总记录，里面是每行的记录
				
				for(int k=1;k<sheets[i].getRows();k++){//读取多少行
					
					List<String> linelist=new ArrayList<String>();//将一行的值放入lineList
					
					for(int j=0;j<sheets[i].getColumns();j++){//取得一行的列数
						
						Cell cell=sheets[i].getCell(j,k);//读出每行的每个单元格数据
						String cellStr=cell.getContents();//得到单元格的内容
						
						if (cell.getType() == CellType.LABEL) {
							LabelCell ctr = (LabelCell) cell;
							cellStr = ctr.getString();
						}
						linelist.add(cellStr);
					}	
					allLineList.add(linelist);
				}
				sheetList.add(allLineList);
					
			}
			// 关闭
			rwb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sheetList;
	}
	public static void main(String[] args){
	//ExcelHandle.readExcel("E:/test.xls");
		
	}
}
