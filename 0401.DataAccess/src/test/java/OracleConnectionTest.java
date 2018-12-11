

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class OracleConnectionTest  {
	
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
	public static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String username = "madang";
	public static final String password = "madang";

	@Test
	public void testConnection() {

		try {
			
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			System.out.println(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	
	}
}