package Guru;

import java.io.IOException;

import Common.BaseClass;

public class Tf extends BaseClass {

	public static void main(String[] args) throws IOException{
		String fileName=createFolderFile(System.getProperty("user.dir")+"/Report/","FCM",".html");
		System.out.println(fileName);
		
	}	
	
	
}