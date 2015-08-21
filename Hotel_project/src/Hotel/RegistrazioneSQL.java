package Hotel;

import java.sql.*;

import javax.swing.*;

import java.awt.*;
import java.util.*;

public class RegistrazioneSQL {

	public Connection con;
	public int cnt = 0;
	public String usname, uspasswd;
	public boolean checked;
	public int ctr;
	public int count=0;	//variabile per contare le occorrenze dello username che voglio registrare

	
	public RegistrazioneSQL(String usnames, String uspasswds, boolean checkeds)
	{
			String url = "jdbc:ucanaccess://oop.accdb";
			//	String url = "jdbc:odbc:lib";
		
		//Load the driver to allow connection to the database
		try {
 			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
 			//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 			con = DriverManager.getConnection(url);
 		}
 		catch(ClassNotFoundException cnfex)  {
 			System.err.println("Failed to load driver");
 			cnfex.printStackTrace();
 			System.exit(1);
 		}
 		catch(SQLException sqlex){
 			System.err.println("unable to connect");
 			sqlex.printStackTrace();
 		}
 		usname = usnames;
 		uspasswd = uspasswds;
 		checked = checkeds;
 		
 		check();
 		
 	}		
 			public boolean check()
 			{ 
 			try
 				{
 					Statement s = con.createStatement();
 					String sqlsel = "SELECT * FROM User WHERE username = '" + usname + "'";
 					
 					ResultSet rs = s.executeQuery(sqlsel);
 					try
 					{
 						while(rs.next()){						
 							count++;
 						}	 	
 			 			if(count == 0){
 							//non ci sono altri utenti con quello username, inserisco i dati nel db
 							checked = true;
 							return checked;
 						}
 						else { 
 							checked = false;
 							return checked;
 						}
	 				}
 					
 					catch(SQLException sqlex){
 						checked = false; 						
 					}
 									
 				}
 				catch(SQLException sqlex)
 				{
 					System.err.println("unable to connect");
 					sqlex.printStackTrace();
 					JOptionPane.showMessageDialog(null, sqlex);
 				}			
 			
 				return checked;
	}
		
 			public void insert(String name, String pass, String email, String data) {
				
				//costruisco la data nel formato gg/mm/aaaa
				/*String dayString = new String();
				String yearString = new String();
				dayString = Integer.toString(day);
				yearString = Integer.toString(year);
				String data = new String();
				data = new String();
				data.concat(dayString).concat("/").concat(month).concat("/").concat(yearString);
				System.out.println(data);*/
				
				try
 				{
 					Statement s = con.createStatement();
 					String insertUser = "Insert into User (username, password, email, birthday, type) values ('" +
 							name + "' , '" +
 							pass + "' , '" +
 							email + "', '" +
 							data + "', '" +
 							"user" + "')";
 				
 					s.executeUpdate(insertUser);
 					
 					JOptionPane.showMessageDialog(null, "WOW. Successful registration! ");
 					return;
 				}
 				catch(SQLException sqlex)
 				{
 					System.err.println("unable to connect");
 					sqlex.printStackTrace();
 					JOptionPane.showMessageDialog(null, sqlex);
 				}			
				
			}
	
}

