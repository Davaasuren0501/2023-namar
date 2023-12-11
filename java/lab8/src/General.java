public class General  {
    int a,b;
    String name;
    public General(int a, int b, String name ){
        this.a =a;
        this.b=b;
        this.name =name;
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
}
