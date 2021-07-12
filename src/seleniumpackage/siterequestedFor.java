package seleniumpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.Keywords;

public class siterequestedFor {

	List<String> list = new ArrayList<String>();
	private String dbURL, username, password;

	public siterequestedFor() {
		try {
			System.out.println("enter into the class");
			System.out.println("enter into the class" + Keywords.Envronment1);
			String vessel = "", location = "";
			if (Keywords.Envronment1.equalsIgnoreCase("staging")) {

				dbURL = "jdbc:mysql://192.168.104.75:3306/mackproc";// staging
				username = "Read";
				password = "R#@d123";
			} else if (Keywords.Envronment1.equalsIgnoreCase("Testing")) {
				System.out.println("enter into the Testing db");
				dbURL = "jdbc:mysql://192.168.11.201:3306/mackproc";// staging
				username = "Read";
				password = "R#@d1234";

			}

			Class.forName("com.mysql.jdbc.Driver");

			// Creating connection to the database

			Connection con = DriverManager.getConnection(dbURL, username,
					password);
			// Creating statement object
			Statement st = con.createStatement();
			String selectquery = "select * from mackproc.uvs_proc_vesselmaster where active_status ='A' order by vsl_code ;";
			String selectquery1 = "select * from mackproc.shore_location Where DEL_FLG ='N' order by SHORE_CODE ;";

			ResultSet rs = st.executeQuery(selectquery);
			// While loop to iterate through all data and print results

			vessel = "Select";
			list.add(vessel);
			while (rs.next()) {

				vessel = rs.getString(2);

				list.add(vessel);

				System.out.println(vessel);

			}

			ResultSet rs1 = st.executeQuery(selectquery1);
			// While loop to iterate through all data and print results

			while (rs1.next()) {

				location = "Select";
				location = rs1.getString(3);

				list.add(location);
				System.out.println(location);

			}

			// System.out.println(list);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
}
