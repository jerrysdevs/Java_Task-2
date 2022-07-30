package com.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Deletedata {
	private static Logger demoLogger = LogManager.getLogger(Log4j.class.getName());

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/employees?useSSL=false";
		String user = "root";
		String password = "password";

		System.out.println("Please enter the employee id to delete the data");

		Scanner inp = new Scanner(System.in);
		String str = inp.nextLine();
		int i = Integer.parseInt(str);
		try (Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement()) {
			// Update data in database
			String q1 = "Delete FROM emp WHERE empid='"+i+"'";
			int x = st.executeUpdate(q1);
			if (x > 0)
			    System.out.println("Deleted Successfully");
			else
				demoLogger.error("Delete Failed");

			con.close();

		} catch (Exception e) {
			demoLogger.error(e);
		}

	}

}
