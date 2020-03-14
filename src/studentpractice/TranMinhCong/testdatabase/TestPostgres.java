package studentpractice.TranMinhCong.testdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import studentpractice.phamquangdung.jdbcpostgres.TestJDBCPostgresConnector;

public class TestPostgres {

	public void test1(){
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(
			"jdbc:postgresql://localhost:5432/Covid19" , "postgres" , "190200");
			System.out.println("Java test");
			System.out.println("connected");
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM covid_country");
			while(rs.next()) {
				System.out.println(rs.getString("country_id") + "\t" + rs.getString("country_name") + "\t" + 
			rs.getString("total_deaths"));
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPostgres app = new TestPostgres();
		app.test1();
	}

}
