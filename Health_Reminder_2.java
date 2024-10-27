// ReminderService.java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReminderService {
    private List<Reminder> reminders = new ArrayList<>();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void addReminder(String message, int intervalMinutes) {
        Reminder reminder = new Reminder(message, intervalMinutes);
        reminders.add(reminder);

        // Schedule the reminder task
        scheduler.scheduleAtFixedRate(() -> triggerReminder(reminder),
                intervalMinutes, intervalMinutes, TimeUnit.MINUTES);

        System.out.println("Reminder added: " + reminder);
    }

    private void triggerReminder(Reminder reminder) {
        System.out.println("Reminder: " + reminder.getReminderMessage() + " | Time: " + LocalDateTime.now());
        reminder.updateNextReminderTime();
    }

    public void displayReminders() {
        if (reminders.isEmpty()) {
            System.out.println("No active reminders.");
        } else {
            for (Reminder reminder : reminders) {
                System.out.println(reminder);
            }
        }
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}
