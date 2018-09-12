package com.company.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class MySQLConnection2 {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER = "javabook";
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL,USER,PW)){
				System.out.println(con);
				con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}