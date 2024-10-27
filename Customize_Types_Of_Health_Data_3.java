// HealthDataPreferences.java
import java.util.HashSet;
import java.util.Set;

public class HealthDataPreferences {
    private Set<String> selectedDataTypes;

    public HealthDataPreferences() {
        this.selectedDataTypes = new HashSet<>();
    }

    public void addDataType(String dataType) {
        selectedDataTypes.add(dataType.toLowerCase());
    }

    public void removeDataType(String dataType) {
        selectedDataTypes.remove(dataType.toLowerCase());
    }

    public boolean isDataTypeSelected(String dataType) {
        return selectedDataTypes.contains(dataType.toLowerCase());
    }

    public Set<String> getSelectedDataTypes() {
        return selectedDataTypes;
    }
}
