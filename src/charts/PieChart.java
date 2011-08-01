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

import java.text.AttributedString;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart extends JFrame {
	private static final long serialVersionUID = 1L;
	private float pass;
	private int fail;
	private float total;
	public PieChart(String appTitle, String chartTitle, float pass, int fail, 
			float total){
		super(appTitle);
		this.pass = pass;
		this.fail = fail;
		this.total = total;
		PieDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset, chartTitle);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new java.awt.Dimension(600, 500));
		setContentPane(panel);
	}

	private PieDataset createDataset(){
		DefaultPieDataset result = new DefaultPieDataset();
		float failPer = (fail/total)*100;
		float passPer = (pass/total)*100;
		DecimalFormat df = new DecimalFormat("#.##");
		result.setValue("Fail - "+df.format(failPer)+"%", fail);
		result.setValue("Pass - "+df.format(passPer)+"%", pass);
		return result;
	}
	private JFreeChart createChart(PieDataset dataset, String chartTitle){
		JFreeChart chart = ChartFactory.createPieChart3D(chartTitle, dataset,
				true, true, false);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		plot.setLabelGenerator(new CustomLabelGenerator());
		return chart;
	}
	
	static class CustomLabelGenerator implements PieSectionLabelGenerator{
		public String generateSectionLabel(final PieDataset dataset,
				final Comparable key){
			String temp = null;
			if (dataset != null){
				temp = dataset.getValue(key).toString();
			}
			return temp;
		}

		@Override
		public AttributedString generateAttributedSectionLabel(PieDataset arg0,
				Comparable arg1) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
