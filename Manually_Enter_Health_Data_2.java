// HealthDataService.java
import java.util.ArrayList;
import java.util.List;

public class HealthDataService {
    private List<HealthData> healthDataEntries;

    public HealthDataService() {
        this.healthDataEntries = new ArrayList<>();
    }

    public void addHealthData(double weight, int heartRate, int bloodPressureSystolic, int bloodPressureDiastolic) {
        HealthData data = new HealthData(weight, heartRate, bloodPressureSystolic, bloodPressureDiastolic);
        healthDataEntries.add(data);
        System.out.println("Health data added successfully.");
    }

    public void displayHealthData() {
        if (healthDataEntries.isEmpty()) {
            System.out.println("No health data records available.");
        } else {
            System.out.println("Displaying all health data entries:");
            for (HealthData data : healthDataEntries) {
                System.out.println(data);
                System.out.println("----------------------------------");
            }
        }
    }
}
