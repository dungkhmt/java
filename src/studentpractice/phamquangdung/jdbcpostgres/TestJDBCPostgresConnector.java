package studentpractice.phamquangdung.jdbcpostgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBCPostgresConnector {

	public void test1() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/baseweb", "postgres",
					"123456");

			System.out.println("Java JDBC PostgreSQL Example");
			System.out.println("Connected to PostgreSQL database!");
			Statement statement = connection.createStatement();
			System.out.println("Reading car records...");
			System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
			ResultSet rs = statement
					.executeQuery("SELECT * FROM public.party");
			while (rs.next()) {
				System.out.println(rs.getString("party_id") + "\t" + rs.getString("party_type_id"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestJDBCPostgresConnector app = new TestJDBCPostgresConnector();
		app.test1();
	}

}
