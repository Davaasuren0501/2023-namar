import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DifferentFileIO {
    File file;
    ArrayList array;
    DifferentFileIO(){
        file=new File("./src//f.dat");
        try {
            WriteToFileF(file);
            WriteToFileG(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    void WriteToFileF( File file) throws IOException {
        int min = -100;
        int max = -1;
        FileOutputStream out;
        out=new FileOutputStream(file);
        Random random = new Random();
        for(int i=0;i<10;i++){
            int number = random.nextInt(max - min + 1) + min;
//            System.out.println(number);
            out.write(number);
        }
        int min2 = 1;
        int max3 = 100;
        for(int i=0;i<10;i++){
            int number = random.nextInt(max3 - min2 + 1) + min2;
//            System.out.println(number);
            out.write(number);
        }
        out.close();
    }

    void WriteToFileG(File file) throws IOException {
        File fileH=new File("./src//h.dat");
        File fileG=new File("./src//g.dat");
        FileOutputStream outH=new FileOutputStream(fileH);
        FileOutputStream outG=new FileOutputStream(fileG);
        FileInputStream inF  =new FileInputStream(file);
        FileInputStream inH  =new FileInputStream(fileH);
        FileInputStream inG  =new FileInputStream(fileG);
        while(inF.available()>0){
            int readNumber = inF.read();
            if(readNumber>0){
                outH.write(readNumber);
            } else {
                outG.write(readNumber);
            }
        }
        inF.close();
        outH.close();
        outG.close();
        while(inH.available()>0){
            outG.write(inH.read());
        }
        inH.close();
        while(inG.available()>0){
            System.out.println(inG.read());
        }
        inG.close();
    }

    public static void main(String[] args) {
        new DifferentFileIO();
    }
}
