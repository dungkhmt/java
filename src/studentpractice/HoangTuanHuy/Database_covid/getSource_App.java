package studentpractice.HoangTuanHuy.Database_covid;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class getSource_App 
{
	OkHttpClient client = new OkHttpClient();
	private String doGetrequest(String URL) throws IOException
	{
		Request rq = new Request
				.Builder()
				.url(URL)
				.build();
		
		Response res = client
				.newCall(rq)
				.execute();
		return res.body().string();
	}
	private void getTablesourcehtml(String url,String filename) throws IOException
	{
		String html = doGetrequest(url);
		
		File file = new File(filename);
		PrintStream print = new PrintStream(file);
		
		int id1 = html.indexOf("<table");
		int id2 = html.indexOf("</table>");
		String code = html.substring(id1, id2);
		
		print.println(code);
		
		print.close();
	}
	public void run(String html,String filename) throws IOException
	{
		getTablesourcehtml( html,filename);

	}
}
