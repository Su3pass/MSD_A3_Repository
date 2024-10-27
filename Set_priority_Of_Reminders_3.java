// Reminder.java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reminder {
    private String reminderMessage;
    private LocalDateTime nextReminderTime;
    private int intervalMinutes; // Interval in minutes for the reminder
    private String priority;     // Priority level (High, Medium, Low)

    public Reminder(String reminderMessage, int intervalMinutes, String priority) {
        this.reminderMessage = reminderMessage;
        this.intervalMinutes = intervalMinutes;
        this.priority = priority;
        this.nextReminderTime = LocalDateTime.now().plusMinutes(intervalMinutes);
    }

    public String getReminderMessage() { return reminderMessage; }
    public LocalDateTime getNextReminderTime() { return nextReminderTime; }
    public String getPriority() { return priority; }

    public void updateNextReminderTime() {
        this.nextReminderTime = LocalDateTime.now().plusMinutes(intervalMinutes);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Priority: " + priority + " | Reminder: " + reminderMessage +
                " | Next Reminder Time: " + nextReminderTime.format(formatter);
    }
}
