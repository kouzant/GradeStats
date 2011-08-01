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
