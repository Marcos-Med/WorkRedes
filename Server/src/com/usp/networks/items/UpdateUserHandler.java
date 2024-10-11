package com.usp.networks.items;

import java.sql.SQLException;

public class UpdateUserHandler implements Handler{
	public StringBuilder execute(String[] p) {
		Database db = Database.getDB();
		StringBuilder msg = new StringBuilder("MSG;");
		ResultConnection rs = db.executeSelect("SELECT * FROM Users WHERE id = '" + p[1] + "';");
		try {
			while(rs.getResultSet().next()) {
				String login = rs.getResultSet().getString("login");
				if(login.compareTo("admin@usp.br") == 0) {
					msg.append("\"cannot update standard user\":");
					System.out.println("Cannot update standard user");
					return msg;
				}
			}
		}
		catch(SQLException e) {
			StringBuilder msgException = new StringBuilder("MSG;");
	    	msgException.append("\"Database error\":");
	    	System.out.println("Error in Database");
	    	return msgException;
		}
		Boolean flag = db.executeSQL("UPDATE Users SET fname = '"+ p[2] +"',lname = '" + p[3] +
				"', password = '" + p[5] + "', admin = "+ p[6] + " WHERE id = " + p[1] +";");
		if(flag) {
			msg.append("\"User updated with sucess\":");
			System.out.println("User updated with sucess");
		}
		else { 
			msg.append("\"Unable to updated user\":");
			System.out.println("Unable to updated user");
		}
		return msg;
	}
}
