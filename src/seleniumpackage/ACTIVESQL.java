package seleniumpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import config.Keywords;

public class ACTIVESQL {
		
	 List <String>list = new ArrayList<String> ();
	 
	private String dbURL,username,password;

	public ACTIVESQL() {
			try {
		
				String   activeRecord ="";
		
			  if(Keywords.Envronment.equalsIgnoreCase("staging")){
			  
			  dbURL = "jdbc:mysql://192.168.104.75:3306/mackproc";//staging
				 username = "Read";
				password ="R#@d123" ;
			  }else if(Keywords.Envronment.equalsIgnoreCase("Testing")){
				
				  dbURL = "jdbc:mysql://192.168.11.201:3306/mackproc";//staging
					 username = "Read";
					password ="R#@d1234" ;  
				  
			  }
			        //Load MySQL JDBC Driver
			        
						Class.forName("com.mysql.jdbc.Driver");
					
			        
			        //Creating connection to the database
			        
			        Connection con = DriverManager.getConnection(dbURL,username,password);
			        //Creating statement object
			     Statement st = con.createStatement();
			     String selectquery = Keywords.ActiveRecordQuery;
			    
			 
			     ResultSet rs = st.executeQuery(selectquery);
			     //While loop to iterate through all data and print results
			     
			     
			     
			    
			     while (rs.next()) {
			    	 
			    	 
			    	
			    	 activeRecord =rs.getString(1);
			    	
			   
			     
			     
			     list.add(activeRecord);
			    
			     
			    // System.out.println(list1);
			    	
				     
				     //System.out.println(vessel);
			    	 
			     }
		     
			     
			     
			     
			     
		
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

