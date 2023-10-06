public class HighYearException  extends Exception {
    String error;
    public HighYearException( String error ){
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
