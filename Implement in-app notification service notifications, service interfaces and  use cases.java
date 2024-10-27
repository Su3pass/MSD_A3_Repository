import com.google.firebase.messaging.FirebaseMessaging;  
import com.google.firebase.messaging.Message;  
  
import java.util.HashMap;  
import java.util.Map;  
  
public class InAppNotificationService {  
  
    private final FirebaseMessaging firebaseMessaging;  
  
    public InAppNotificationService() {  
        // Initialize the Firebase Admin SDK  
        try {  
            FirebaseApp.initializeApp();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        this.firebaseMessaging = FirebaseMessaging.getInstance();  
    }  
  
    public void sendNotification(String registrationToken, String title, String body) {  
        // Create a notification message  
        Message message = Message.builder()  
                .putData("title", title)  
                .putData("body", body)  
                .setToken(registrationToken)  
                .build();  
  
        // Send the message  
        try {  
            String response = firebaseMessaging.send(message);  
            System.out.println("Notification sent successfully: " + response);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
public interface NotificationService {  
    void sendNotification(String recipient, String title, String body);  
}
public class NotificationServiceFactory {  
  
    public static NotificationService getService(String type, String... params) {  
        switch (type.toLowerCase()) {  
            case "email":  
                if (params.length != 4) throw new IllegalArgumentException("Email service requires 4 parameters");  
                return new EmailNotificationService(params[0], params[1], params[2], params[3]);  
            case "in-app":  
                if (params.length != 1) throw new IllegalArgumentException("In-app service requires 1 parameter");  
                return new InAppNotificationService();  
            default:  
                throw new IllegalArgumentException("Unsupported notification type");  
        }  
    }  
}
public class Main {  
    public static void main(String[] args) {  
        try {  
            // Email Notification  
            NotificationService emailService = NotificationServiceFactory.getService("email",  
                    "smtp.example.com", "587", "your-email@example.com", "your-email-password");  
            emailService.sendNotification("recipient@example.com", "Email Title", "This is an email notification.");  
  
            // In-App Notification  
            NotificationService inAppService = NotificationServiceFactory.getService("in-app");  
            inAppService.sendNotification("firebase-registration-token", "In-App Title", "This is an in-app notification.");  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}