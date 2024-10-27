java

	public class HealthDataTrendAnalysis {  

	    public static void main(String[] args) {  

	        HealthDataRepository repository = new HealthDataRepository();  

	          

	        // Add some sample data  

	        repository.addMetric(new HealthMetric(LocalDateTime.now().minusDays(9), "BloodPressure", 120, "Patient1"));  

	        repository.addMetric(new HealthMetric(LocalDateTime.now().minusDays(8), "BloodPressure", 122, "Patient1"));  

	        repository.addMetric(new HealthMetric(LocalDateTime.now().minusDays(7), "BloodPressure", 125, "Patient1"));  

	        repository.addMetric(new HealthMetric(LocalDateTime.now().minusDays(6), "BloodPressure", 130, "Patient1"));  

	        repository.addMetric(new HealthMetric(LocalDateTime.now().minusDays(5), "BloodPressure", 135, "Patient1"));  

	        repository.addMetric(new HealthMetric(LocalDateTime.now().minusDays(4), "BloodPressure", 140, "Patient1"));  

	        repository.addMetric(new HealthMetric(LocalDateTime.now().minusDays(3), "BloodPressure", 145, "Patient1"));  

	        repository.addMetric(new HealthMetric(LocalDateTime.now().minusDays(2), "BloodPressure", 150, "Patient1"));  

	        repository.addMetric(new HealthMetric(LocalDateTime.now().minusDays(1), "BloodPressure", 155, "Patient1"));  

	        repository.addMetric(new HealthMetric(LocalDateTime.now(), "BloodPressure", 160, "Patient1"));  

	  

	        List<HealthMetric> metrics = repository.getMetricsByPatient("Patient1");  

	        List<Double> averages = TrendAnalyzer.calculateMovingAverage(metrics, 3);  

	        String trend = TrendAnalyzer.detectTrend(averages);  

	  

	        System.out.println("Trend for Patient1's BloodPressure: " + trend);  

	    }  

	}