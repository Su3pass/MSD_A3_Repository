@Entity
public class HealthData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deviceId;
    private String dataType; // 例如：心率、步数等
    private double value;
    private String timestamp; // 使用 ISO 8601 格式（例如 "2024-10-27T12:00:00Z"）

    // Getters and Setters...
}
