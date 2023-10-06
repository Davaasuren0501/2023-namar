public class PasswordException extends Exception {
    public PasswordException() {
        super("Password and Confirm Password do not match.");
    }

    public PasswordException(String message) {
        super(message);
    }
}
