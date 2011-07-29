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
	private float pass;
	private int fail;
	public PieChart(String appTitle, String chartTitle, float pass, int fail){
		super(appTitle);
		this.pass = pass;
		this.fail = fail;
		PieDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset, chartTitle);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new java.awt.Dimension(600, 500));
		setContentPane(panel);
	}

	private PieDataset createDataset(){
		DefaultPieDataset result = new DefaultPieDataset();
		DecimalFormat df = new DecimalFormat("#");
		String passS = df.format(pass);
		String failS = String.valueOf(fail);
		result.setValue("Pass", pass);
		result.setValue("Fail", fail);
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
