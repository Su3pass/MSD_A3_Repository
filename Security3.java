// Main.java
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        // 注册用户
        userService.registerUser("user@example.com", "password123");

        // 尝试登录
        boolean loginSuccess = userService.loginUser("user@example.com", "password123");

        // 如果登录成功，显示欢迎信息
        if (loginSuccess) {
            System.out.println("Welcome to the system!");
            userService.logoutUser("user@example.com");
        } else {
            System.out.println("Access denied.");
        }
    }
}
