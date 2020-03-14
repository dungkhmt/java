package studentpractice.HoangTuanHuy.Database_covid;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.sun.net.httpserver.Authenticator.Result;

public class App 
{
	public void run() throws Exception
	{
		Class.forName("org.postgresql.Driver");
		
		Connection connect = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/Covid19" , "postgres" , "01679359668"	);
		
		System.out.println("Successfully Access.");
		Statement statement =  connect.createStatement(); 
		ResultSet rs = statement.executeQuery(
				"SELECT * FROM covid_country"
				);
		while(rs.next())
		{
			System.out.println(rs.getString("country_name") + "\t" + rs.getString("country_id") +
					"\t" + rs.getString("area_id")+"\t"+rs.getInt("total_cases")+"\t"+rs.getInt("totla_deaths"));
		}
		rs.close();
		statement.close();
	}
	public static void main(String[] args) throws Exception
	{
		App my_app = new App();
		my_app.run();
	}
}
