public class ClientException extends Exception {
    String error;
    public ClientException( String error ){
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
