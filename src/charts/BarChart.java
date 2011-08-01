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
package charts;

import java.text.DecimalFormat;
import java.util.HashMap;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class BarChart extends JFrame{
	private static final long serialVersionUID = 1L;
	HashMap<Integer, Integer> exp;
	private float total;
	public BarChart(String appTitle, String chartTitle,
			HashMap<Integer, Integer> exp, float total){
		super(appTitle);
		this.exp = exp;
		this.total = total;
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset, chartTitle);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new java.awt.Dimension(600, 500));
		setContentPane(panel);
	}
	
	private CategoryDataset createDataset(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		DecimalFormat df = new DecimalFormat("#.##");
		for(int i=0; i<=10; i++){
			int value = exp.get(i);
			dataset.addValue(value, new Integer(i), df.format((value/total)*100)
					+"% "+i);
		}
		return dataset;
	}
	private JFreeChart createChart(CategoryDataset dataset, String chartTitle){
		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle,
				"Grades Category", "Grades", dataset, PlotOrientation.VERTICAL,
				true, true, false);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setForegroundAlpha(0.6f);
		NumberAxis3D axisRange = (NumberAxis3D) plot.getRangeAxis();
		axisRange.setStandardTickUnits(NumberAxis3D.createIntegerTickUnits());
		
		CategoryAxis3D domainAxis = (CategoryAxis3D)plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
		return chart;
	}
}
