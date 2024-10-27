// User.java
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String email;
    private String passwordHash; // 存储加密后的密码
    private boolean isLoggedIn = false;

    public User(String email, String password) {
        this.email = email;
        this.passwordHash = hashPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public boolean authenticate(String password) {
        if (this.passwordHash.equals(hashPassword(password))) {
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
