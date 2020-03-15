package studentpractice.HoangTuanHuy.Database_covid_worldometers;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import studentpractice.HoangTuanHuy.Database_covid.Filter_app;
import studentpractice.HoangTuanHuy.Database_covid.Insert_app;
import studentpractice.HoangTuanHuy.Database_covid.Update_app;
import studentpractice.HoangTuanHuy.Database_covid.getData_app;
import studentpractice.HoangTuanHuy.Database_covid.getSource_App;

public class App 
{
	Filter_app my_filter = new Filter_app();
	getSource_App my_getsourceapp = new getSource_App();
	getData_app my_data = new getData_app();
	Insert_app my_insert = new Insert_app();
	Update_app my_update = new Update_app();
	public static void main(String[] args) throws Exception
	{
		App my_app = new App();
		my_app
			.my_getsourceapp
				.run(
						"https://www.worldometers.info/coronavirus/?fbclid=IwAR2RCmu6-PAEKT9ifIKTOnXunyoxPmsL_sPVA4iSavZkONDI_YurtcipVIE",
						"data/Huysfiletest/Table.html"
					);
		my_app
			.my_filter
				.run(
						"data/Huysfiletest/Table.html", 
						"data/Huysfiletest/Table_distributed.html"
					);
		my_app
			.my_data
				.run(
						"data/Huysfiletest/Table_distributed.html",
						"data/Huysfiletest/ListCountryName.out"
					);
		
		ArrayList<String> ListName = my_app.my_data.getListname();
		ArrayList<String> Total_cases = my_app.my_data.getTotal_cases();
		ArrayList<String> Total_deaths = my_app.my_data.getTotal_deaths();
		
		//my_app.my_insert.run("data/Huysfiletest/Covid19_Table", ListName, Total_cases, Total_deaths);
		
		my_app.my_update.run("data/Huysfiletest/Covid19_Table", ListName, Total_cases, Total_deaths);
	}
}
