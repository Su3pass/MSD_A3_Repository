import java.util.List;  
import java.util.stream.Collectors;  
  
class TrendAnalyzer {  
      
    // Calculate a simple moving average  
    public static List<Double> calculateMovingAverage(List<HealthMetric> metrics, int windowSize) {  
        List<Double> averages = new ArrayList<>();  
        for (int i = 0; i <= metrics.size() - windowSize; i++) {  
            List<HealthMetric> window = metrics.subList(i, i + windowSize);  
            double sum = window.stream().mapToDouble(HealthMetric::getValue).sum();  
            double average = sum / windowSize;  
            averages.add(average);  
        }  
        return averages;  
    }  
  
    // Detect increasing or decreasing trend using moving averages  
    public static String detectTrend(List<Double> averages) {  
        if (averages.isEmpty()) return "No trend detected";  
  
        double prevAvg = averages.get(0);  
        boolean increasing = true;  
        boolean decreasing = true;  
  
        for (int i = 1; i < averages.size(); i++) {  
            double currentAvg = averages.get(i);  
            if (currentAvg > prevAvg) {  
                decreasing = false;  
            } else if (currentAvg < prevAvg) {  
                increasing = false;  
            }  
            prevAvg = currentAvg;  
        }  
  
        if (increasing) return "Increasing trend";  
        if (decreasing) return "Decreasing trend";  
        return "Stable trend";  
    }  
}