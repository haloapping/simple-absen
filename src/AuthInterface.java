import java.util.Scanner;

public interface AuthInterface {
    public void loginForm(Scanner scanner);
    public Boolean isLogin(String[][] employees);
    public Boolean isLogout();
}
