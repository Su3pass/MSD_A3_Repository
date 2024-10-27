// UserService.java
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>(); // 模拟的用户数据库

    public void registerUser(String email, String password) {
        User user = new User(email, password);
        users.put(email, user);
    }

    public boolean loginUser(String email, String password) {
        User user = users.get(email);
        if (user != null && user.authenticate(password)) {
            System.out.println("Login successful for user: " + email);
            return true;
        } else {
            System.out.println("Invalid email or password.");
            return false;
        }
    }

    public void logoutUser(String email) {
        User user = users.get(email);
        if (user != null) {
            user.isLoggedIn = false;
            System.out.println("User logged out: " + email);
        }
    }
}
