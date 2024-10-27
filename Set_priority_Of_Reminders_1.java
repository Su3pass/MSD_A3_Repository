// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReminderService reminderService = new ReminderService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Health Reminder System:");
            System.out.println("1. Set up a Health Reminder with Priority");
            System.out.println("2. View Active Reminders");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter reminder message: ");
                    scanner.nextLine(); // Consume newline
                    String message = scanner.nextLine();

                    System.out.print("Enter interval in minutes: ");
                    int intervalMinutes = scanner.nextInt();

                    System.out.print("Enter priority (High, Medium, Low): ");
                    scanner.nextLine(); // Consume newline
                    String priority = scanner.nextLine();

                    reminderService.addReminder(message, intervalMinutes, priority);
                    break;

                case 2:
                    reminderService.displayReminders();
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting Health Reminder System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        // Shutdown the scheduler on exit
        reminderService.shutdown();
        scanner.close();
    }
}
