package seleniumpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.Keywords;
import utility.Log;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RateOfExchange {
	public String ROE = "";
	public String ROE1 = "";
	// public static final String QUERY = "select *from pmscategorymaster;";

	public RateOfExchange() {
		try {
			// Keywords exchange1= new Keywords();

			ROE1 = Keywords.Exchange;
			// System.out.println("TEST1234567890"+ROE1);
			String dbURL = "jdbc:mysql://192.168.104.75:3306/mackproc";// testing
			String password = "R#@d123";// testing
			String username = "Read";

			/*
			 * staging String dbURL = "jdbc:mysql://192.168.104.75:3306/mackproc";
			 * 
			 * String password ="R#@d123" ;
			 */

			// Load MySQL JDBC Driver

			Class.forName("com.mysql.jdbc.Driver");

			// Creating connection to the database

			Connection con = DriverManager.getConnection(dbURL, username, password);
			// Creating statement object
			Statement st = con.createStatement();
			String selectquery = "select * from  mackproc.roe where currencycode in (" + "'" + ROE1 + "'" + ")"
					+ "AND basecurrency in('EUR');";

			// System.out.println(selectquery);

			// Executing the SQL Query and store the results in ResultSet
			ResultSet rs = st.executeQuery(selectquery);
			// While loop to iterate through all data and print results
			while (rs.next()) {

				ROE = rs.getString(4);

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
