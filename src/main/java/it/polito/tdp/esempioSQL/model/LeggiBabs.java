package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {
	public void run() {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";
		try {
			Connection conn=DriverManager.getConnection(jdbcURL);
			String sql="SELECT NAME FROM station WHERE landmark= ? ";
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, "Palo Alto");
			ResultSet res=st.executeQuery();
			while(res.next()) {
				String nomestazione=res.getString("name");
				System.out.println(nomestazione);	
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		LeggiBabs babs =new LeggiBabs();
		babs.run();
	}

}
