package business;

import java.util.HashMap;

import charts.BarChart;

public class DrawBar implements Runnable {
	private HashMap<Integer, Integer> exp;
	private String lesson;
	public DrawBar(HashMap<Integer, Integer> exp, String lesson){
		this.exp = exp;
		this.lesson = lesson;
	}
	@Override
	public void run() {
		BarChart barChart = new BarChart("GradeStat", lesson, exp);
		barChart.pack();
		barChart.setLocation(630, 100);
		barChart.setVisible(true);
		Thread.yield();
	}

}
