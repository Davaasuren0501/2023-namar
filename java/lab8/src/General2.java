public class General2 implements Runnable{
    int a,b;
    String name;
    boolean check;
    public General2(int a, int b, String name, Boolean check ){
        this.a =a;
        this.b=b;
        this.name =name;
        this.check = check;
    }
    boolean isPrime(int p){
        int t=(int) Math.sqrt(p);
        for(int i=2; i<=t; i++){
            if(p%i == 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        for(int ind=a; ind<=b;ind++){
            if( check ) {
                if( this.isPrime(ind)) {
                    System.out.println( name + " prime number = " + ind );
                }
            } else {
                if( !this.isPrime(ind)) {
                    System.out.println( name + "not prime number = " + ind );
                }
            }
        }
    }
}