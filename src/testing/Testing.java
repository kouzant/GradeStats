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
