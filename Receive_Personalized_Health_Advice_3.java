// HealthDataService.java
import java.util.ArrayList;
import java.util.List;

public class HealthDataService {
    private List<HealthData> healthDataEntries = new ArrayList<>();
    private HealthAdviceEngine adviceEngine = new HealthAdviceEngine();

    public void addHealthData(double weight, int heartRate, int systolicBloodPressure, int diastolicBloodPressure) {
        HealthData data = new HealthData(weight, heartRate, systolicBloodPressure, diastolicBloodPressure);
        healthDataEntries.add(data);
        System.out.println("Health data added successfully.");
    }

    public void displayHealthData() {
        if (healthDataEntries.isEmpty()) {
            System.out.println("No health data records available.");
        } else {
            for (HealthData data : healthDataEntries) {
                System.out.println(data);
                System.out.println("----------------------------------");
            }
        }
    }

    public void providePersonalizedAdvice() {
        if (healthDataEntries.isEmpty()) {
            System.out.println("No health data available for advice.");
        } else {
            HealthData latestData = healthDataEntries.get(healthDataEntries.size() - 1); // Get the latest entry
            String advice = adviceEngine.generateAdvice(latestData);
            System.out.println(advice);
        }
    }
}
