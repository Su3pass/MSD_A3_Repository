import java.time.LocalDateTime;  
import java.util.ArrayList;  
import java.util.List;  
  
class HealthMetric {  
    private LocalDateTime timestamp;  
    private String metricName;  
    private double value;  
    private String patientId;  
  
    // Constructor, getters, and setters  
    public HealthMetric(LocalDateTime timestamp, String metricName, double value, String patientId) {  
        this.timestamp = timestamp;  
        this.metricName = metricName;  
        this.value = value;  
        this.patientId = patientId;  
    }  
  
    // Getters and Setters  
    public LocalDateTime getTimestamp() { return timestamp; }  
    public String getMetricName() { return metricName; }  
    public double getValue() { return value; }  
    public String getPatientId() { return patientId; }  
}  
  
class HealthDataRepository {  
    private List<HealthMetric> metrics;  
  
    public HealthDataRepository() {  
        this.metrics = new ArrayList<>();  
    }  
  
    public void addMetric(HealthMetric metric) {  
        metrics.add(metric);  
    }  
  
    public List<HealthMetric> getMetricsByPatient(String patientId) {  
        List<HealthMetric> patientMetrics = new ArrayList<>();  
        for (HealthMetric metric : metrics) {  
            if (metric.getPatientId().equals(patientId)) {  
                patientMetrics.add(metric);  
            }  
        }  
        return patientMetrics;  
    }  
  
    // Add other methods to filter, sort, and manage metrics  
}