package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {			//program start
	public static java.sql.Statement st=null;
	public static  Connection conn=null;
	public static ResultSet rs=null;

	public static void main(String[] args){

		try{
			conn=DriverManager.getConnection("jdbc:mysql://125.180.206.12:3306/se?autoReconnect=true&useSSL=false","guest","");
			st=conn.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}
		Login start = new Login();
	}
}
