import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CheckLogin {
    private String login;
    private String password;
    private String confirmPassword;

    public CheckLogin(String login, String password, String confirmPassword) throws LoginNameException, PasswordException {
        validateLoginName(login);
        validatePassword(password, confirmPassword);
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    private void validateLoginName(String login) throws LoginNameException {
        if (login.length() > 20) {
            throw new LoginNameException("Login name hamgiin bagadaa 20 temdegt baih ystoi.");
        }

        if (!login.matches("^[a-zA-Z0-9_]+$")) {
            throw new LoginNameException("Login name tom useg bolon too aguulah ystoi");
        }
    }

    private void validatePassword(String password, String confirmPassword) throws PasswordException {
        if (!password.equals(confirmPassword)) {
            throw new PasswordException("Password 1 and Password 2 taarahgui baina.");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Login name oruulna uu: ");
            String loginname = scanner.nextLine();
            System.out.println("Pass oruulna uu: ");
            String pass1 = scanner.nextLine();
            System.out.println("Pass dahin oruulna uu: ");
            String pass2 = scanner.nextLine();
            new CheckLogin(loginname, pass1, pass2);
            System.out.println("Sign up successful");
            scanner.close();
        } catch (LoginNameException | PasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}