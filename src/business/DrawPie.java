package business;

import charts.PieChart;

public class DrawPie implements Runnable {
	private float pass;
	private int fail;
	public DrawPie(float pass, int fail){
		this.pass = pass;
		this.fail = fail;
	}
	@Override
	public void run() {
		PieChart pieChart = new PieChart("GradeStat", "Pie CHart", pass, fail);
		pieChart.pack();
		pieChart.setLocation(20, 100);
		pieChart.setVisible(true);
		Thread.yield();
	}

}
