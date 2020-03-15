package studentpractice.HoangTuanHuy.Database_covid;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Insert_app 
{
	private String insert_into_table(String country_id, String country_name,String total_cases,String total_deaths)
	{
		return ("insert into covid_country_mirror(country_id,country_name,total_cases,total_deaths) values(" +
				"'" + country_id+ "'," +
				"'" + country_name+"',"+
				"'" + total_cases + "',"+
				"'" + total_deaths+"')");
	}
	private String show_table(String what , String where)
	{
		return "select "+what+" from " +where;
	}
	public void run(String filename,ArrayList<String> Listname,ArrayList<String> Total_cases, ArrayList<String> Total_deaths) throws Exception
	{
		Class.forName("org.postgresql.Driver");
		
		Connection connect = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/Covid19_on_worldometers" , "postgres" , "01679359668"	);
		
		
		///System.out.println("Successfully Access.");
		PrintStream print = new PrintStream(filename);
		
		Statement statement =  connect.createStatement(); 
		
		int n = Listname.size();
		for(int i=0;i<n-1;i++)
		{
			int _n=Listname.size();
			statement.execute(
					insert_into_table(Listname.get(i).toUpperCase(),
							Listname.get(i),
							Total_cases.get(i),
							Total_deaths.get(i))
							);
		}
		ResultSet rs = statement.executeQuery(
				show_table("*","covid_country_mirror")
				);
		while(rs.next())
		{
			print.println(rs.getString("country_name") + "\t" + rs.getString("country_id") +
					"\t"+rs.getString("total_cases")+"\t"+rs.getString("total_deaths"));
		}
		rs.close();
		statement.close();
		print.close();
	}
}
