package JohnsonAlg.JohnsonAlg;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;

public class Graphic {

	
	 ArrayList<Task> tasks = new ArrayList<Task>();
	 ArrayList<Machine> schedule = new ArrayList<Machine>();
	 
	 void makeChart() {
	        JFreeChart chart = createIntervalStackedChart();
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chart.removeLegend();
	        chartPanel.setPreferredSize(new Dimension(600, 450));
	        File scheduleChart = new File("harmonogram.png");
	 
	        try {
	            ChartUtilities.saveChartAsPNG(scheduleChart, chart, 800, 400);
	        } catch (IOException e) {
	            System.out.println("Problem z zapisaniem harmonogramu");
	        }
	    }
	 
	    private JFreeChart createIntervalStackedChart() {
	        XYIntervalSeriesCollection dataset = createXYIntervalDataset();
	        XYBarRenderer xyRend = new XYBarRenderer();
	        xyRend.setShadowVisible(false);
	        xyRend.setUseYInterval(true);
	        xyRend.setBarPainter(new StandardXYBarPainter());
	        xyRend.setBaseItemLabelGenerator((XYItemLabelGenerator) new StandardXYItemLabelGenerator("{0}", NumberFormat.getInstance(), NumberFormat.getInstance()));
	 
	        xyRend.setBaseItemLabelsVisible(true);
	 
	        NumberAxis numAxis = new NumberAxis();
	        numAxis.setVerticalTickLabels(true);
	        numAxis.setTickUnit(new NumberTickUnit(1));
	 
	        XYPlot plot = new XYPlot(dataset, new SymbolAxis("", new String[]{"M3", "M2", "M1"}), numAxis, xyRend);
	        plot.setOrientation(PlotOrientation.HORIZONTAL);
	        plot.setBackgroundPaint(Color.LIGHT_GRAY);
	        return new JFreeChart(plot);
	    }
	 
	 
	    private XYIntervalSeriesCollection createXYIntervalDataset() {
	        XYIntervalSeriesCollection dataset = new XYIntervalSeriesCollection();
	        int machineNumber = 2;
	        int duration;
	        int taskStart;
	        int machineSize;
	        XYIntervalSeries[] series = new XYIntervalSeries[tasks.size()];
	        for (int i = 0; i < tasks.size(); i++) {
	            series[i] = new XYIntervalSeries("Z" + (i + 1));
	            dataset.addSeries(series[i]);
	        }
	 
	        for (Machine machine : schedule) {
	            machineSize = machine.schedule.size();
	            duration = 1;
	            taskStart = 0;
	 
	            for (int i = 0; i < machineSize; i++) {
	                if (machine.schedule.get(i).getTaskNumber() == 0) {
	                    taskStart++;
	                    duration = 1;
	                    continue;
	                }
	                if (i != machine.schedule.size() - 1) {
	                    if (!(machine.schedule.get(i + 1).getTaskNumber() == machine.schedule.get(i).getTaskNumber())) {
	                        series[machine.schedule.get(i).getTaskNumber() - 1].add(machineNumber, machineNumber - 0.2, machineNumber + 0.2, taskStart, taskStart, taskStart + duration);
	                        taskStart = taskStart + duration;
	                        duration = 1;
	                    } else {
	                        duration++;
	                    }
	                } else {
	                    series[machine.schedule.get(i).getTaskNumber() - 1].add(machineNumber, machineNumber - 0.2, machineNumber + 0.2, taskStart, taskStart, taskStart + duration);
	                }
	            }
	            machineNumber--;
	        }
	        return dataset;
	    }
}
