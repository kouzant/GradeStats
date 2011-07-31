package business;

import charts.PieChart;

public class DrawPie implements Runnable {
	private float pass;
	private int fail;
	private String lesson;
	public DrawPie(float pass, int fail, String lesson){
		this.pass = pass;
		this.fail = fail;
		this.lesson = lesson;
	}
	@Override
	public void run() {
		PieChart pieChart = new PieChart("GradeStat", lesson, pass, fail);
		pieChart.pack();
		pieChart.setLocation(20, 100);
		pieChart.setVisible(true);
		Thread.yield();
	}

}
