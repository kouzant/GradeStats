package charts;

import java.util.HashMap;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class BarChart extends JFrame{
	HashMap<Integer, Integer> exp;
	public BarChart(String appTitle, String chartTitle,
			HashMap<Integer, Integer> exp){
		super(appTitle);
		this.exp = exp;
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset, chartTitle);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new java.awt.Dimension(600, 500));
		setContentPane(panel);
	}
	
	private CategoryDataset createDataset(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		//columns
		String category = "Grades";
		for(int i=0; i<=10; i++){
			dataset.addValue(exp.get(i), new Integer(i), category);
		}
		return dataset;
	}
	private JFreeChart createChart(CategoryDataset dataset, String chartTitle){
		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle,
				"Grades Category", "Grades", dataset, PlotOrientation.VERTICAL,
				true, true, false);
		return chart;
	}
}
