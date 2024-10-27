// HealthReportGenerator.java
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HealthReportGenerator {

    public String generateReport(List<HealthData> healthDataEntries) {
        StringBuilder report = new StringBuilder("Health Report\n\n");

        if (healthDataEntries.isEmpty()) {
            return "No health data available for report generation.\n";
        }

        for (HealthData data : healthDataEntries) {
            report.append(data).append("\n");
            report.append("----------------------------------\n");
        }

        return report.toString();
    }

    public void exportReportToFile(List<HealthData> healthDataEntries, String filename) {
        String report = generateReport(healthDataEntries);

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(report);
            System.out.println("Health report exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting report to file: " + e.getMessage());
        }
    }
}
