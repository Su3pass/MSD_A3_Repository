// HealthData.java
import java.time.LocalDateTime;

public class HealthData {
    private double weight; // in kilograms
    private int heartRate; // in bpm (beats per minute)
    private int bloodPressureSystolic;
    private int bloodPressureDiastolic;
    private LocalDateTime entryTime;

    public HealthData(double weight, int heartRate, int bloodPressureSystolic, int bloodPressureDiastolic) {
        this.weight = weight;
        this.heartRate = heartRate;
        this.bloodPressureSystolic = bloodPressureSystolic;
        this.bloodPressureDiastolic = bloodPressureDiastolic;
        this.entryTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Health Data: " +
                "\nWeight: " + weight + " kg" +
                "\nHeart Rate: " + heartRate + " bpm" +
                "\nBlood Pressure: " + bloodPressureSystolic + "/" + bloodPressureDiastolic +
                "\nEntry Time: " + entryTime;
    }
}
