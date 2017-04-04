package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectTest {
	private static final String URL="jdbc:mysql://localhost:3306/liaody";
	private static final String DRIVERCLASSNAME="com.mysql.jdbc.Driver";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	private static Statement state;
	
/*	private static final String testQuery = "select user"*/
	public DBConnectTest() throws ClassNotFoundException{
		Class.forName(DRIVERCLASSNAME);
	}
	public Connection getConnect() throws SQLException{
		Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return conn;
	}
	public  static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Connection conn = new DBConnectTest().getConnect();
		state = conn.createStatement();
	String sql = "select * from userinfo";
	
		ResultSet rs = state.executeQuery(sql);
		while(rs.next()){
        System.out.println(rs.getString("user_id"));
        System.out.println(rs.getString("user_name"));
        System.out.println(rs.getString("user_password"));
        System.out.println(rs.getString("user_email"));

		}
	}

}
