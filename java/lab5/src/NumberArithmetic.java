import java.io.*;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class NumberArithmetic {
    File file = null;
    NumberArithmetic() {
        file=new File("./src//realNumbers.dat");
        try {
//            WriteToFile(file);
            System.out.println(getSum(file));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    void WriteToFile( File file ) throws IOException {
        FileOutputStream out;
        out=new FileOutputStream(file);
        Random random = new Random();
        for(int i=0;i<100;i++){
            out.write(random.nextInt(1000));
        }
        out.close();
    }
    long getSum(File file) throws IOException {
        FileInputStream in  =new FileInputStream(file);
        long sum = 0;
        while(in.available()>0){
            sum+=in.read();
        }
        in.close();
        return sum;
    }
    public static void main(String[] args) {
        new NumberArithmetic();
    }
}