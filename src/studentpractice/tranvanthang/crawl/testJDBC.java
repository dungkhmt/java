package studentpractice.tranvanthang.crawl;
import java.sql.*;
public class testJDBC{
	public static void test(){
		try{
			Class.forName("org.postgresql.Driver");
			Connection conection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/covid19","postgres","tranthang");
			Statement stat=conection.createStatement();
			
			ResultSet rs=stat.executeQuery("SELECT * FROM covid_country");
			while(rs.next()){
				System.out.println(rs.getString("country_id")+"\t"+
						rs.getInt("total_cases"));
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public static void main(String[] args){
		test();
	}
}