package testing;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String url = "http://students.unipi.gr/courseRelults.asp?dpcID=&orID=&mnuID=mnu5&studpg=&prID=&courseID=20002530&isDil=";
		int counter = 0;
		Document doc = Jsoup.connect(url).get();
		String title = doc.title();
		System.out.println(title);
		Iterator<Element> table0 = doc.select("table[class=tablebordercolor]").iterator();
		Iterator<Element> table1 = doc.select("table[class=tablebordercolor]").iterator();

		table0.next();
		table1.next();
		//Iterator<Element> tableCon = table.next().select("td[valign=top]").iterator();
		Iterator<Element> pass = table0.next().getElementsByClass("tablebold").iterator();
		Iterator<Element> fail = table1.next().getElementsByClass("redFonts").iterator();
		
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
