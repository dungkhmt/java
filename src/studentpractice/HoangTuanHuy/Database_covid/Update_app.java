package studentpractice.HoangTuanHuy.Database_covid;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Update_app 
{
	String update_data(String data_name,String Name,String total_cases,String total_deaths)
	{
		return ("update " + data_name + 
				" set total_cases='" + total_cases + "'," +
				" total_deaths='" + total_deaths + "'" +
				"where country_id='" +Name +"';"
				);
				
	}
	private String show_table(String what , String where)
	{
		return "select "+what+" from " +where;
	}
	public void run(String filename,ArrayList<String> Listname,ArrayList<String> Total_cases, ArrayList<String> Total_deaths) throws Exception
	{
		Class.forName("org.postgresql.Driver");
		
		Connection connect = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/Covid19_on_worldometers" , "postgres" , "01679359668"
				);
		
		PrintStream print = new PrintStream(filename);
		
		Statement state = connect.createStatement();
		
		int n=Listname.size();
		for(int i=0;i<n-1;i++)
		{
			int _n=Listname.size();
			state.execute(
					update_data("covid_country_mirror",
							Listname.get(i).toUpperCase(),
							Total_cases.get(i),
							Total_deaths.get(i))
							);
			System.out.println(update_data("covid_country_mirror",
					Listname.get(i).toUpperCase(),
					Total_cases.get(i),
					Total_deaths.get(i))
					);
		}
		
		ResultSet rs = state.executeQuery(
				show_table("*","covid_country_mirror")
				);
		
		while(rs.next())
		{
			print.println(rs.getString("country_name") + "\t" + rs.getString("country_id") +
					"\t"+rs.getString("total_cases")+"\t"+rs.getString("total_deaths"));
		}
		rs.close();
		state.close();
		print.close();
	}
}
