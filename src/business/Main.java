package business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		int pass = 0;
		int fail = 0;
		ScrapeGrades sg = new ScrapeGrades(args[0]);
		LinkedList<Integer> grades = sg.scrape();
		System.out.println(grades);
		HashMap<Integer, Integer> exp = new HashMap<Integer, Integer>();
		for(int i = 0; i <= 10; i++)
			exp.put(i, 0);
		Iterator<Integer> gradesIt = grades.iterator();
		while(gradesIt.hasNext()){
			int tmpGrade = gradesIt.next();
			if(tmpGrade >= 5)
				pass++;
			else
				fail++;
			int curCount = exp.get(tmpGrade);
			exp.put(tmpGrade, ++curCount);
		}
		System.out.println(exp);
		System.out.println("Pass: "+pass);
		System.out.println("Fail: "+fail);
	}

}
