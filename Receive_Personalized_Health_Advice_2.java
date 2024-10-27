// HealthAdviceEngine.java
public class HealthAdviceEngine {

    public String generateAdvice(HealthData healthData) {
        StringBuilder advice = new StringBuilder("Personalized Health Advice:\n");

        if (healthData.getWeight() > 80) {
            advice.append("Consider a balanced diet and regular exercise to maintain a healthy weight.\n");
        } else {
            advice.append("Your weight is within a healthy range. Maintain your routine!\n");
        }

        if (healthData.getHeartRate() > 100) {
            advice.append("Your heart rate is higher than normal. Consider reducing stress and incorporating relaxation techniques.\n");
        } else if (healthData.getHeartRate() < 60) {
            advice.append("Your heart rate is lower than normal. Check with a healthcare provider if you experience symptoms.\n");
        } else {
            advice.append("Your heart rate is within the healthy range. Keep up the good work!\n");
        }

        if (healthData.getSystolicBloodPressure() > 120 || healthData.getDiastolicBloodPressure() > 80) {
            advice.append("Your blood pressure is elevated. Monitor your diet and reduce sodium intake.\n");
        } else {
            advice.append("Your blood pressure is within a healthy range. Great job!\n");
        }

        return advice.toString();
    }
}
