package cmdUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import learningUtil.Data;

public class databaseAdmin {
	public String insertData(String tableName, ArrayList<String> columnNames, ArrayList<String> values) throws ClassNotFoundException, SQLException{
		String sql = "INSERT INTO " + tableName + " (";
		for(int i = 0; i < columnNames.size(); i++){
			if(i == 0) {
				sql = sql + columnNames.get(i);
			} else {
				sql = sql + "," + columnNames.get(i);
			}
		}
		sql = sql + ") VALUES (";
		
		for(int i = 0; i < values.size(); i++) {
			if(i == 0) {
				sql = sql + values.get(i);
			} else {
				sql = sql + "," + values.get(i);
			}
		}
		
		sql = sql + ")";
		Connection conn = Data.establishConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		return "Done";
	}
	
	public String deleteData(String tableName, String[] data){
		
		return null;
	}
	
	public String showData(String tableName, String[] data){
		
		return null;
	}
	
	public String executesqlStmt(String tableName, String[] data){
		
		return null;
	}

}
