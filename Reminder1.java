import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HealthReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String reminderTime; // ISO 8601 格式（例如 "2024-10-27T12:00:00Z"）

    // Getters and Setters...
}
