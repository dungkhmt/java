package studentpractice.TranMinhCong.testdatabase;
import java.io.IOException;
import java.io.PrintWriter;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class getDataFromWeb {
	
	OkHttpClient client = new OkHttpClient();
	
	String doGetRequest(String url) throws IOException{
		Request request = new Request.Builder().url(url).build();
		
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
	public void getSourceHtml(String url) {
		try {
			String html = doGetRequest(url);
			PrintWriter out = new PrintWriter("E:\\LearnJava\\java\\src\\studentpractice\\TranMinhCong\\testdatabase\\output\\crawl-output.html");

			int idx1 = html.indexOf("<table");
			int idx2 = html.indexOf("</table");
			String s1 = html.substring(idx1 , idx2);
			System.out.println(s1);
			
			out.print(s1);
			out.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		String s = "Tran Minh Cong ";
		int idx1 = s.indexOf("an");
		int idx2 = s.indexOf("on");
		System.out.print(s.substring(idx1 , idx2));
		
		getDataFromWeb data = new getDataFromWeb();
		data.getSourceHtml("https://www.worldometers.info/coronavirus/");
		// TODO Auto-generated method stub

	}

}
