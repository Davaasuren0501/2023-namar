public class ClientExceptionTest {
    public ClientExceptionTest(){
        try {
            Solve(1,2,1);
        } catch (ClientException e) {
            System.out.println(e.getError());
        }
    }

    void Solve( double a, double b, double c ) throws ClientException {
        double x1, x2;
        double discreminate = b*b - 4*a*c;
        if( discreminate < 0 ) {
            throw new ClientException("Shiidgui");
        } else {
            x1 = (-b +Math.sqrt(discreminate))/(2*a);
            x2 = (-b -Math.sqrt(discreminate))/(2*a);
            System.out.println("shiid = " +x1 +" " + x2);
        }
    }

    public static void main(String[] args) {
        new ClientExceptionTest();
    }
}
