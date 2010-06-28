package com.king.tools;

public class Common {

		public String Convert(String s){

		String result = "";

		byte[] temp ;

		try{

		temp = s.getBytes("iso-8859-1");

		result = new String(temp,"utf-8");

		}catch(Exception e){
			
		}
		return result;
		}
		
	
}
