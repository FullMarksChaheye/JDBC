import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	static final String URL = "jdbc:mysql:///prac";
	static final String USERNAME = "root";
	static final String PASSWORD = "fast";
	
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		if(con == null) {
			throw new Exception("Couldn't Create the connection");
		}
		
		PreparedStatement ps = con.prepareStatement("SHOW TABLES;");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		
		rs.close();
		ps.close();
		con.close();
		
	}

}
