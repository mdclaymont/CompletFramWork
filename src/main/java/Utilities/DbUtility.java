package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;

public class DbUtility {
	public static Connection objConnection;
	
	/****************************************************************************************************************
	*  Author: Md Rezaul Karim 
	*  Function Name: setUpDb
	*  Function Arg: expectedUrl ==>Which Url Or Domain You want work for
	*  FunctionOutPut: It will open Url That you want Automated
	* 
	* ***************************************************************************************************************/
	
	public static void setUpDb(){
		String dbUrl=null;
		String expDbName="",UserId = null,UserPw = null,mysqljdbcdriver = null;
		try {
			Class.forName(mysqljdbcdriver);
			objConnection=DriverManager.getConnection(dbUrl,UserId,UserPw);
			if(objConnection!=null) {
				System.out.println("Conetting...");
			}
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}
	public static void getDataFromDb(String expQueary) {
		Hashtable<String,String> htd= new Hashtable<String,String>();
	}
	public static void tearDownDb() {
		if(objConnection!=null) {
			try {
				objConnection.close();
			}catch(SQLException ex)
				{
					ex.printStackTrace();
				}
			}
			
		}
	}

}
