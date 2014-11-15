package learningUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data {
	public static Connection establishConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:sqlserver://BHUPPI-PC\\SQLEXPRESS;integratedSecurity=true;databaseName=MachineLearning";
		// jdbc:sqlserver://\\SQLEXPRESS;database=MachineLearning
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(url);
		return conn;
	}
}
