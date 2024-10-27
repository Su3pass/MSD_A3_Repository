java

	import org.jfree.chart.ChartFactory;  

	import org.jfree.chart.ChartPanel;  

	import org.jfree.chart.JFreeChart;  

	import org.jfree.chart.plot.PlotOrientation;  

	import org.jfree.chart.plot.XYPlot;  

	import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;  

	import org.jfree.data.xy.XYSeries;  

	import org.jfree.data.xy.XYSeriesCollection;  

	import org.jfree.ui.ApplicationFrame;  

	import org.jfree.ui.RefineryUtilities;  

	  

	import javax.swing.*;  

	import java.awt.*;  

	import java.time.format.DateTimeFormatter;  

	import java.util.List;  

	  

	public class HealthDataTrendVisualizer extends ApplicationFrame {  

	  

	    public HealthDataTrendVisualizer(String title) {  

	        super(title);  

	        JFreeChart chart = createChart(createDataset());  

	        ChartPanel chartPanel = new ChartPanel(chart);  

	        chartPanel.setPreferredSize(new Dimension(800, 600));  

	        setContentPane(chartPanel);  

	    }  

	  

	    private XYSeriesCollection createDataset() {  

	        HealthDataRepository repository = new HealthDataRepository();  

	        // Populate repository with data...  

	  

	        List<HealthMetric> metrics = repository.getMetricsByPatient("Patient1");  

	        XYSeries series = new XYSeries("BloodPressure");  

	  

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  

	        for (HealthMetric metric : metrics) {  

	            series.add(metric.getTimestamp().toLocalDate().format(formatter), metric.getValue());  

	        }  

	  

	        XYSeriesCollection dataset = new XYSeriesCollection();  

	        dataset.addSeries(series);  

	        return dataset;  

	    }  

	  

	    private JFreeChart createChart(XYSeriesCollection dataset) {  

	        JFreeChart chart = ChartFactory.createXYLineChart(  

	                "Blood Pressure Trend",  

	                "Date",  

	                "Blood Pressure",  

	                dataset,  

	                PlotOrientation.VERTICAL,  

	                true, true, false);  

	  

	        XYPlot plot = chart.getXYPlot();  

	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();  

	        renderer.setSeriesShapesVisible(0, false);  

	        plot.setRenderer(renderer);  

	  

	        return chart;  

	    }  

	  

	    public static void main(String[] args) {  

	        SwingUtilities.invokeLater(() -> {  

	            HealthDataTrendVisualizer chart = new HealthDataTrendVisualizer("Blood Pressure Trend Analysis");  

	            chart.pack();  

	            RefineryUtilities.centerFrameOnScreen(