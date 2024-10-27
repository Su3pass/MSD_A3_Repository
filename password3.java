import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JavaMailSender mailSender;

    @Autowired
    public UserService(UserRepository userRepository, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    public String initiatePasswordReset(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "User not found!";
        }

        String token = UUID.randomUUID().toString();
        user.setResetToken(token);
        userRepository.save(user);

        String resetLink = "http://localhost:8080/reset/" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset Request");
        message.setText("Please click the link to reset your password: " + resetLink);
        mailSender.send(message);

        return "Password reset link sent!";
    }

    public String resetPassword(String token, String newPassword) {
        User user = userRepository.findByResetToken(token);
        if (user == null) {
            return "Invalid or expired token!";
        }

        user.setPassword(newPassword); // 应该在这里进行密码加密
        user.setResetToken(null);
        userRepository.save(user);

        return "Password has been reset!";
    }
}
