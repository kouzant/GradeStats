package business;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeGrades {
	private String url;
	
	public ScrapeGrades(String url){
		this.url = url;
	}
	
	public ScrapeResult scrape(){
		LinkedList<Integer> grades = new LinkedList<Integer>();
		ScrapeResult sr = null;
		try{
			Document doc = Jsoup.connect(url).get();
			Elements lessonEl = doc.select("div[class=tablebold]");
			String lesson = lessonEl.text();
			String[] tmpLesson = lesson.split("[)]");
			String[] tmpLesson1 = tmpLesson[1].split("[-]");
			
			Elements table = doc.select("table[id=tablemain]");
			Iterator<Element> passGrades = table.select("span.tablebold")
			.iterator();
			Iterator<Element> failGrades = table.select("span.redFonts")
			.iterator();
			
			while(passGrades.hasNext())
				grades.add(Integer.parseInt(passGrades.next().text()));
			while(failGrades.hasNext())
				grades.add(Integer.parseInt(failGrades.next().text()));
			sr = new ScrapeResult(tmpLesson1[0].trim(), grades);
		}catch(IOException e0){
			e0.printStackTrace();
		}
		return sr;
	}
}
