package com.task2;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.*;

public class Insertdata {
	private static Logger demoLogger = LogManager.getLogger(Log4j.class.getName());
	public static void main(String[] args) {

		String empname = "Siranjeevi";
		Integer empsalary = 100000;
		Integer emptype = 1;

		String url = "jdbc:mysql://localhost:3306/employees?useSSL=false";
		String user = "root";
		String password = "password";


		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement()) {
			// Inserting data in database
			String q1 = "insert into emp (empname,empsalary,emptype) values('" + empname + "', '" + empsalary + "', '" + emptype + "')";
			int x = st.executeUpdate(q1);
			if (x > 0)
				System.out.println("Successfully Inserted");
			else
				System.out.println("Insert Failed");

			con.close();

		} catch (Exception e) {
			demoLogger.error(e);
		}

	}

}
