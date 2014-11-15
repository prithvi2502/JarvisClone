package cmdUtil;

import java.sql.SQLException;

public interface util {
	public int cmdcode(String $cmdName);
	
	public String cmdName(int $cmdCode);
	
	public String cmdClass();

	String cmdName(int $cmdCode, String $cmdName) throws ClassNotFoundException, SQLException;
}
