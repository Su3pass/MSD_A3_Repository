import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailService1 {

    public void sendVerificationEmail(EmailService2 user) {
        String to = user.getEmail();
        String from = "your-email@example.com";
        String host = "smtp.example.com"; // SMTP 服务器地址
        String verificationLink = "https://your-domain.com/verify?token=" + user.getVerificationToken();

        // 设置邮件服务器的配置信息
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587"); // SMTP 端口
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your-email@example.com", "your-password");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Account Verification");
            message.setText("Please verify your account by clicking the link: " + verificationLink);

            Transport.send(message);
            System.out.println("Verification email sent to " + user.getEmail());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
