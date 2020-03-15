import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {
	
	public void test1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mytestdb", "root", "password!"
					);
			
			//System.out.println("Java JDBC MySQL Example");
			//System.out.println("Connected to MySQL database!");
			
			Statement stat = connection.createStatement();
			
			ResultSet rs = stat.executeQuery("SELECT * FROM covid_country");
			while(rs.next()) {
				System.out.println(rs.getString("country_id") + "\t" + rs.getString("country_name") 
				+ "\t" + rs.getInt("total_cases"));
			}
			String country_id = "VN";
			String country_name = "Vietnam";
			int total_cases = 53;
			String sql = "insert into covid_country (country_id, country_name, total_cases)" 
			+ " value ('" + country_id + "', '" + country_name + "', " + total_cases + ")";
			System.out.println("sql = " + sql);
			stat.executeUpdate(sql);
			
			connection.close();
		} catch(Exception ex) {
			ex.getStackTrace();
		}
	}
	
	public static void main(String args[]) {
		TestJDBC app = new TestJDBC();
		app.test1();
	}
}
