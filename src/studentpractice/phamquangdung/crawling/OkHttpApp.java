package studentpractice.phamquangdung.crawling;

import java.io.IOException;
import java.io.PrintWriter;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpApp {
	OkHttpClient client = new OkHttpClient();

	// code request code here
	String doGetRequest(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public void getSourceHtml(String url){
		try{
			String html = doGetRequest(url);
			PrintWriter out = new PrintWriter("output/crawl-output.html");
			//out.print(html);
			
			int idx1 = html.indexOf("<table");
			int idx2 = html.indexOf("</table");
			String s1 = html.substring(idx1, idx2);
			System.out.println(s1);
			out.print(s1);
			//System.out.print(html);
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		String s = "Dai hoc Bach KHoa Ha Noi";
		int idx1 = s.indexOf("Bac");
		int idx2 = s.indexOf("Ha");
		System.out.println("idx1 = " + idx1 + ", idx2 = " + idx2 + ", sub = " + s.substring(idx1,idx2));
		
		//OkHttpApp app = new OkHttpApp();
		//app.getSourceHtml("https://www.worldometers.info/coronavirus/");
	}
}
