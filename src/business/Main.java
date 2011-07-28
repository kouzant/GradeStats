package business;

import java.util.LinkedList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ScrapeGrades sg = new ScrapeGrades(args[0]);
		LinkedList<Integer> grades = sg.scrape();
		System.out.println(grades);
	}

}
