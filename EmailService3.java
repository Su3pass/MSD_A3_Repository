import java.util.HashMap;
import java.util.Map;

public class EmailService3 {
    private Map<String, EmailService2> userDatabase = new HashMap<>(); // 模拟数据库

    public void registerUser(String email) {
        EmailService2 user = new EmailService2(email);
        userDatabase.put(user.getVerificationToken(), user);

        // 发送验证邮件
        EmailService1 emailService = new EmailService1();
        emailService.sendVerificationEmail(user);
    }

    public String verifyUser(String token) {
        EmailService2 user = userDatabase.get(token);

        if (user != null && !user.isVerified()) {
            user.verify();
            return "Account verified successfully!";
        } else {
            return "Invalid or already verified token.";
        }
    }
}
