import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/healthdata")
public class HealthDataController {
    private final HealthDataService healthDataService;

    @Autowired
    public HealthDataController(HealthDataService healthDataService) {
        this.healthDataService = healthDataService;
    }

    @PostMapping("/sync")
    public ResponseEntity<String> syncData(@RequestBody HealthData healthData) {
        healthDataService.synchronizeData(healthData);
        return ResponseEntity.ok("Data synchronized successfully!");
    }

    @GetMapping
    public ResponseEntity<List<HealthData>> getAllData() {
        return ResponseEntity.ok(healthDataService.getAllData());
    }

    @GetMapping("/compare")
    public ResponseEntity<List<HealthData>> compareData(@RequestParam String startDate, @RequestParam String endDate) {
        List<HealthData> data = healthDataService.getDataByPeriod(startDate, endDate);
        return ResponseEntity.ok(data);
    }
}
