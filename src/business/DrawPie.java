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

import charts.PieChart;

public class DrawPie implements Runnable {
	private float pass;
	private int fail;
	private String lesson;
	private float total;
	public DrawPie(float pass, int fail, String lesson, float total){
		this.pass = pass;
		this.fail = fail;
		this.lesson = lesson;
		this.total = total;
	}
	@Override
	public void run() {
		PieChart pieChart = new PieChart("GradeStat", lesson, pass, fail, total);
		pieChart.pack();
		pieChart.setLocation(20, 100);
		pieChart.setVisible(true);
		Thread.yield();
	}

}
