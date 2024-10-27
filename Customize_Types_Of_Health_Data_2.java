// HealthData.java
import java.time.LocalDateTime;

public class HealthData {
    private Double weight; // in kilograms
    private Integer heartRate; // in bpm (beats per minute)
    private Integer bloodPressureSystolic;
    private Integer bloodPressureDiastolic;
    private LocalDateTime entryTime;

    public HealthData() {
        this.entryTime = LocalDateTime.now();
    }

    public void setWeight(Double weight) { this.weight = weight; }
    public void setHeartRate(Integer heartRate) { this.heartRate = heartRate; }
    public void setBloodPressureSystolic(Integer systolic) { this.bloodPressureSystolic = systolic; }
    public void setBloodPressureDiastolic(Integer diastolic) { this.bloodPressureDiastolic = diastolic; }

    @Override
    public String toString() {
        return "Health Data Entry:" +
                (weight != null ? "\nWeight: " + weight + " kg" : "") +
                (heartRate != null ? "\nHeart Rate: " + heartRate + " bpm" : "") +
                (bloodPressureSystolic != null && bloodPressureDiastolic != null ?
                        "\nBlood Pressure: " + bloodPressureSystolic + "/" + bloodPressureDiastolic : "") +
                "\nEntry Time: " + entryTime;
    }
}
