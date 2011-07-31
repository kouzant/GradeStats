package business;

import java.util.LinkedList;

public class ScrapeResult {
	private String lesson;
	private LinkedList<Integer> grades;
	
	public ScrapeResult(String lesson, LinkedList<Integer> grades){
		this.lesson = lesson;
		this.grades = grades;
	}
	
	public String getLesson(){
		return lesson;
	}
	public LinkedList<Integer> getGrades(){
		return grades;
	}
}
