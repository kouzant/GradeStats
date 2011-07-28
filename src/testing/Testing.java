package testing;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		int counter = 0;
		Document doc = Jsoup.connect(args[0]).get();
		String title = doc.title();
		System.out.println(title);
		Elements table = doc.select("table[id=tablemain]");
	
		Iterator<Element> pass = table.select("span.tablebold").iterator();
		Iterator<Element> fail = table.select("span.redFonts").iterator();
		
		while(pass.hasNext()){
			System.out.println(pass.next().text());
			counter++;
		}
		
		while(fail.hasNext()){
			System.err.println(fail.next().text());
			counter++;
		}
		System.out.println("Total: "+counter);
	}

}
