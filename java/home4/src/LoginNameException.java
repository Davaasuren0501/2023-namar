public class LoginNameException extends Exception {
    public LoginNameException() {
        super("Login name is invalid.");
    }

    public LoginNameException(String message) {
        super(message);
    }
}
