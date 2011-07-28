package business;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeGrades {
	private String url;
	
	public ScrapeGrades(String url){
		this.url = url;
	}
	
	public LinkedList<Integer> scrape(){
		LinkedList<Integer> grades = new LinkedList<Integer>();
		try{
			Document doc = Jsoup.connect(url).get();
			Elements table = doc.select("table[id=tablemain]");
			
			Iterator<Element> passGrades = table.select("span.tablebold")
			.iterator();
			Iterator<Element> failGrades = table.select("span.redFonts")
			.iterator();
			
			while(passGrades.hasNext())
				grades.add(Integer.parseInt(passGrades.next().text()));
			while(failGrades.hasNext())
				grades.add(Integer.parseInt(failGrades.next().text()));
		}catch(IOException e0){
			e0.printStackTrace();
		}
		return grades;
	}
}
