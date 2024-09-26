package com.usp.networks.items;

public class DeleteAssHandler implements Handler {
	public StringBuilder execute(String[] p) {
		Database db = Database.getDB();
		StringBuilder msg = new StringBuilder("MSG;");
		Boolean flag = db.executeSQL("DELETE FROM UserZoneMapping WHERE user_id = " + p[1] +
				" AND zone_id = " + p[2] + ";");
		if(flag) {
			msg.append("\"Association Zone-User deleted with sucess\":");
			System.out.println("Association Zone-User deleted with sucess");
		}
		else {
			msg.append("\"Unable to delete association zone-user\":");
			System.out.println("Unable to delete association zone-user");
		}
		return msg;
	}
}
