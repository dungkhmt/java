import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMySQL {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/TestSQL";
			String username = "root";
			String password = "root";
			
			Connection connection = DriverManager.getConnection(url, username, password);
			if(connection !=null) {
				System.out.println("Connect success");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generates catch block
			e.printStackTrace();
		}
		
	}
}
