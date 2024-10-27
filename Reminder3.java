import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;

@Service
public class HealthReminderService {
    private final HealthReminderRepository reminderRepository;
    private final Calendar googleCalendarService;

    @Autowired
    public HealthReminderService(HealthReminderRepository reminderRepository, Calendar googleCalendarService) {
        this.reminderRepository = reminderRepository;
        this.googleCalendarService = googleCalendarService;
    }

    public void addReminder(HealthReminder reminder) {
        reminderRepository.save(reminder);
        syncWithGoogleCalendar(reminder);
    }

    private void syncWithGoogleCalendar(
