package studentpractice.tranvanthang.crawl;

import java.io.File;
import java.io.FileWriter;
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

	/**
	 * @param url
	 */
	/**
	 * @param url
	 */
	public void getSourceHtml(String url) {
		try {
			String html = doGetRequest(url);
			int index_html = 0;
			////delete 
			html = html.replaceAll("<!--<td", "\t");
			html = html.replaceAll("td>-->", "\t");
			FileWriter file = new FileWriter("output/covid153.txt");
			
			///find
			index_html = 0;
			int index_next_row = 0;
			while (html.indexOf("<td", index_html) > 0) {
				int idx1 = html.indexOf("<td", index_html);
				int idx2 = html.indexOf("</td", index_html);
				index_html = idx2 + 5;
				String str = html.substring(idx1, idx2 + 5);
				
				if (str.indexOf("<a") > 0) {
					
					index_next_row++;
					int index2 = str.indexOf("</a");
					int index1 = str.indexOf(">", index2 - 35);// //35 space	back										
					String temp = str.substring(index1 + 1, index2);
					temp = temp.replaceAll("\\s+", "");
					file.write(temp + " ");
					if (index_next_row % 9 == 0) {
						file.write("\n");
					}
					
					
				} else {
					int index2 = str.indexOf("</td");
					int index1 = str.indexOf(">", index2 - 35);// //35 space back
					String temp = str.substring(index1 + 1, index2);
					if (temp.contains("%") == false) {
						index_next_row++;
						if (temp.equals(" ")) {
							temp = "0";
						}
						////delete space name of nation, delete "," integer
						temp = temp.replaceAll("\\s+", "");
						temp=temp.replace(",", "");
						file.write(temp.trim() + " ");
						
						////// 1 nation 1row
						if (index_next_row % 9 == 0) {
							file.write("\n");
						}
					}
				}
			}

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {

		OkHttpApp app = new OkHttpApp();
		app.getSourceHtml("https://www.worldometers.info/coronavirus/?fbclid=IwAR3-6Y8UkbjIP0Mz8W_dj-VAk9G17uMSR8tPQ1uj-OK23Dn4W6Dd642G_4c#countries");
	}
}