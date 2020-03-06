package studentpractice.phamquangdung.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
			Document doc = Jsoup.connect("https://www.mckinsey.com/industries/electric-power-and-natural-gas/our-insights/the-future-of-natural-gas-in-north-america?cid=other-eml-alt-mip-mck&hlkid=f887cea4797541729afb41b1fd412735&hctky=11733486&hdpid=fa38edd9-ca10-40ac-85a8-80ddc01e5227").get();
			
			System.out.println(doc.body().text());
			Elements newsHeadlines = doc.select("#mp-itn b a");
			for (Element headline : newsHeadlines) {
				System.out.println("%s\n\t%s" + headline.attr("title") + "  "
						+ headline.absUrl("href"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
