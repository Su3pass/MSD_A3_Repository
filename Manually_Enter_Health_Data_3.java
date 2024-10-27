// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HealthDataService healthDataService = new HealthDataService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Health Data Entry System:");
            System.out.println("1. Add Health Data");
            System.out.println("2. Display Health Data");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter weight (kg): ");
                    double weight = scanner.nextDouble();

                    System.out.print("Enter heart rate (bpm): ");
                    int heartRate = scanner.nextInt();

                    System.out.print("Enter systolic blood pressure: ");
                    int bloodPressureSystolic = scanner.nextInt();

                    System.out.print("Enter diastolic blood pressure: ");
                    int bloodPressureDiastolic = scanner.nextInt();

                    healthDataService.addHealthData(weight, heartRate, bloodPressureSystolic, bloodPressureDiastolic);
                    break;

                case 2:
                    healthDataService.displayHealthData();
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting Health Data Entry System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
