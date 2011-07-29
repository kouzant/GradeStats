package business;

import java.util.HashMap;

import charts.BarChart;

public class DrawBar implements Runnable {
	private HashMap<Integer, Integer> exp;
	public DrawBar(HashMap<Integer, Integer> exp){
		this.exp = exp;
	}
	@Override
	public void run() {
		BarChart barChart = new BarChart("GradeStat", "Bar Chart", exp);
		barChart.pack();
		barChart.setLocation(630, 100);
		barChart.setVisible(true);
		Thread.yield();
	}

}
