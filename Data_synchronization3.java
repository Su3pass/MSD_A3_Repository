import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthDataService {
    private final HealthDataRepository healthDataRepository;

    @Autowired
    public HealthDataService(HealthDataRepository healthDataRepository) {
        this.healthDataRepository = healthDataRepository;
    }

    public void synchronizeData(HealthData healthData) {
        healthDataRepository.save(healthData);
    }

    public List<HealthData> getAllData() {
        return healthDataRepository.findAll();
    }
}
