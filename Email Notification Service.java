import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
import java.util.Properties;  
  
public class EmailNotificationService {  
  
    private final String smtpHost;  
    private final String smtpPort;  
    private final String username;  
    private final String password;  
  
    public EmailNotificationService(String smtpHost, String smtpPort, String username, String password) {  
        this.smtpHost = smtpHost;  
        this.smtpPort = smtpPort;  
        this.username = username;  
        this.password = password;  
    }  
  
    public void sendEmail(String to, String subject, String body) throws MessagingException {  
        // Set the SMTP server configuration  
        Properties properties = new Properties();  
        properties.put("mail.smtp.host", smtpHost);  
        properties.put("mail.smtp.port", smtpPort);  
        properties.put("mail.smtp.auth", "true");  
        properties.put("mail.smtp.starttls.enable", "true");  
  
        // Create a new session  
        Session session = Session.getInstance(properties, new Authenticator() {  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(username, password);  
            }  
        });  
  
        // Create a new email message  
        Message message = new MimeMessage(session);  
        message.setFrom(new InternetAddress(username));  
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));  
        message.setSubject(subject);  
        message.setText(body);  
  
        // Send the email  
        Transport.send(message);  
    }  
}