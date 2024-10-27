// HealthDataService.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HealthDataService {
    private List<HealthData> healthDataEntries = new ArrayList<>();
    private HealthDataPreferences preferences;

    public HealthDataService(HealthDataPreferences preferences) {
        this.preferences = preferences;
    }

    public void addHealthData() {
        Scanner scanner = new Scanner(System.in);
        HealthData data = new HealthData();

        if (preferences.isDataTypeSelected("weight")) {
            System.out.print("Enter weight (kg): ");
            data.setWeight(scanner.nextDouble());
        }

        if (preferences.isDataTypeSelected("heart rate")) {
            System.out.print("Enter heart rate (bpm): ");
            data.setHeartRate(scanner.nextInt());
        }

        if (preferences.isDataTypeSelected("blood pressure")) {
            System.out.print("Enter systolic blood pressure: ");
            int systolic = scanner.nextInt();
            System.out.print("Enter diastolic blood pressure: ");
            int diastolic = scanner.nextInt();
            data.setBloodPressureSystolic(systolic);
            data.setBloodPressureDiastolic(diastolic);
        }

        healthDataEntries.add(data);
        System.out.println("Health data added successfully.");
    }

    public void displayHealthData() {
        if (healthDataEntries.isEmpty()) {
            System.out.println("No health data records available.");
        } else {
            for (HealthData data : healthDataEntries) {
                System.out.println(data);
                System.out.println("-------------------------------");
            }
        }
    }
}
