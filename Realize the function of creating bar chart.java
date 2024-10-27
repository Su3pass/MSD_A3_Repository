import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
import org.jfree.ui.ApplicationFrame;  
import org.jfree.ui.RefineryUtilities;  
  
import javax.swing.*;  
import java.awt.*;  
  
public class BarChartExample extends ApplicationFrame {  
  
    public BarChartExample(String title) {  
        super(title);  
  
        // Create dataset  
        CategoryDataset dataset = createDataset();  
  
        // Create chart  
        JFreeChart chart = ChartFactory.createBarChart(  
                "Bar Chart Example",  
                "Category",  
                "Value",  
                dataset,  
                PlotOrientation.VERTICAL,  
                true, true, false);  
  
        // Customize the plot  
        chart.getCategoryPlot().setBackgroundPaint(Color.lightGray);  
        chart.getCategoryPlot().setDomainGridlinePaint(Color.white);  
        chart.getCategoryPlot().setRangeGridlinePaint(Color.white);  
  
        // Create a panel to hold the chart  
        ChartPanel chartPanel = new ChartPanel(chart);  
        chartPanel.setPreferredSize(new Dimension(800, 600));  
        setContentPane(chartPanel);  
    }  
  
    private CategoryDataset createDataset() {  
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
  
        dataset.addValue(10, "Metrics", "Week 1");  
        dataset.addValue(15, "Metrics", "Week 2");  
        dataset.addValue(13, "Metrics", "Week 3");  
        dataset.addValue(17, "Metrics", "Week 4");  
        dataset.addValue(16, "Metrics", "Week 5");  
  
        return dataset;  
    }  
  
    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
            BarChartExample example = new BarChartExample("Health Metrics Bar Chart");  
            example.pack();  
            RefineryUtilities.centerFrameOnScreen(example);  
            example.setVisible(true);  
        });  
    }  
}