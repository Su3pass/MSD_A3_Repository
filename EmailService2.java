//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.UUID;

public class EmailService2 {
    private String email;
    private boolean verified;
    private String verificationToken;

    public EmailService2(String email) {
        this.email = email;
        this.verified = false;
        this.verificationToken = UUID.randomUUID().toString(); // 生成唯一验证令牌
    }

    public String getEmail() { return email; }
    public boolean isVerified() { return verified; }
    public String getVerificationToken() { return verificationToken; }
    public void verify() { this.verified = true; }
}
