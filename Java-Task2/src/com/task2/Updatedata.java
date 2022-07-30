package com.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.logging.log4j.*;

public class Updatedata {
	private static Logger demoLogger = LogManager.getLogger(Log4j.class.getName());

	public static void main(String[] args) {

		String empname = "Siranjeevi";
		Integer empsalary = 100000;
		Integer emptype = 1;

		String url = "jdbc:mysql://localhost:3306/employees?useSSL=false";
		String user = "root";
		String password = "password";
		System.out.println("Please enter the emp id to update");
		Scanner inp = new Scanner(System.in);
		String str = inp.nextLine();
		int i = Integer.parseInt(str);
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement()) {
			
			// Update data in database
			String q1 = "UPDATE emp SET empname='" + empname + "',empsalary='" + empsalary + "',emptype='" + emptype
					+ "' WHERE empid='"+i+"'";
			int x = st.executeUpdate(q1);
			if (x > 0)
				System.out.println("Updated Successfully");
			else
				System.out.println("Update Failed, Please check the emp id");

			con.close();

		} catch (Exception e) {
			demoLogger.error(e);
		}

	}

}
