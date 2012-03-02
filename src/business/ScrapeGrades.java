/*
   Copyright (C) 2011
   Kouzoupis Antonis
   
   This file is part of GradeStats.
 
    GradeStats is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as 
    published by the Free Software Foundation, either version 3 of the 
    License, or (at your option) any later version.

    GradeStats is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with GradeStats.  If not, see <http://www.gnu.org/licenses/>.
 */
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
	
	public ScrapeResult scrape(){
		LinkedList<Integer> grades = new LinkedList<Integer>();
		ScrapeResult sr = null;
		try{
			System.setProperty("javax.net.ssl.trustStore", "ssl/"+
					"GradeStats.jks");
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
