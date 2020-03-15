
import java.io.IOException;
import java.io.PrintWriter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpApp {
	OkHttpClient client = new OkHttpClient();

	String doGetRequest(String url) throws IOException{
		Request request = new Request.Builder().url(url).build();
		
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
	
	public void getSourceHtml(String url) {
		try {
			String html = doGetRequest(url);
			PrintWriter out = new PrintWriter("output/crawl-output.html");
			out.print(html);
			int idx1 = html.indexOf("<table");
			int idx2 = html.indexOf("<\table");
			String s1 = html.substring(idx1, idx2);
			System.out.println(s1);
			out.print(s1);
			System.out.print(html);
			out.close();
			
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OkHttpApp app = new OkHttpApp();
		app.doGetRequest("https://www.worldometers.info/coronavirus/");
		app.getSourceHtml("https://www.worldometers.info/coronavirus/");
			
	}

}
