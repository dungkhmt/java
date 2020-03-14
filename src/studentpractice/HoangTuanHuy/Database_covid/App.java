package studentpractice.HoangTuanHuy.Database_covid;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.sun.net.httpserver.Authenticator.Result;

public class App 
{
	private String insert_into_table(String country_id, String country_name,String area_id,int total_cases,int total_deaths)
	{
		return ("insert into covid_country(country_id,country_name,area_id,total_cases,total_deaths) values(" +
				"'" + country_id+ "'," +
				"'" + country_name+"',"+
				"'" + area_id + "',"+
				total_cases+","+
				total_deaths+")");
	}
	private String show_table(String what , String where)
	{
		return "select "+what+" from " +where;
	}
	private void run() throws Exception
	{
		Class.forName("org.postgresql.Driver");
		
		Connection connect = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/Covid19" , "postgres" , "01679359668"	);
		
		System.out.println("Successfully Access.");
		Statement statement =  connect.createStatement(); 
		//String sql = insert_into_table("BRA","BRAZIL","SA",151,0);
		//System.out.println(sql);
		//System.out.println(show_table("*","country_covid"));
		//statement.executeQuery(sql);
		ResultSet rs = statement.executeQuery(
				show_table("*","covid_country")
				);
		while(rs.next())
		{
			System.out.println(rs.getString("country_name") + "\t" + rs.getString("country_id") +
					"\t" + rs.getString("area_id")+"\t"+rs.getInt("total_cases")+"\t"+rs.getInt("total_deaths"));
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
