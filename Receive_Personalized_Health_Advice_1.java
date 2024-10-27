// HealthData.java
import java.time.LocalDateTime;

public class HealthData {
    private double weight; // kg
    private int heartRate; // bpm
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private LocalDateTime entryTime;

    public HealthData(double weight, int heartRate, int systolicBloodPressure, int diastolicBloodPressure) {
        this.weight = weight;
        this.heartRate = heartRate;
        this.systolicBloodPressure = systolicBloodPressure;
        this.diastolicBloodPressure = diastolicBloodPressure;
        this.entryTime = LocalDateTime.now();
    }

    public double getWeight() { return weight; }
    public int getHeartRate() { return heartRate; }
    public int getSystolicBloodPressure() { return systolicBloodPressure; }
    public int getDiastolicBloodPressure() { return diastolicBloodPressure; }

    @Override
    public String toString() {
        return "Weight: " + weight + " kg, Heart Rate: " + heartRate + " bpm, Blood Pressure: "
                + systolicBloodPressure + "/" + diastolicBloodPressure + " mmHg, Recorded at: " + entryTime;
    }
}
