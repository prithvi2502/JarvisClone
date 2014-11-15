package learningUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;





public class mainLearn {
	public Connection establishConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:sqlserver://BHUPPI-PC\\SQLEXPRESS;integratedSecurity=true;databaseName=MachineLearning";
		// jdbc:sqlserver://\\SQLEXPRESS;database=MachineLearning
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(url);
		return conn;
	}
	public void dataStorage() throws ClassNotFoundException, SQLException{
		Connection conn = establishConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "";
		stmt.executeUpdate(sql);
	}
	public Data dataExtract(){
		return null;
		
	}
	public void dataAlternate(){
		
	}
	public ResultsReport dataExtrapolation(){
		return null;
		
	}
}
