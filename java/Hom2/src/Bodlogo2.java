import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Bodlogo2 {

    public static  void ReadFile( java.io.File file) throws java.io.IOException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scanner input = new Scanner(file);
        System.out.println("Spring month dates");
        while (input.hasNext()) {
            String string = input.nextLine();
            Date date = dateFormat.parse(string);
            int month = date.getMonth();
            if( month>=3 && month<=5 ) {
                System.out.println(date);
            }
        }
        input.close();
    }
    public static void main(String[] args) throws java.io.IOException, ParseException {
        java.io.File file = new java.io.File("date.txt");
        if (file.exists()) {
            System.out.println("File already exists");
        } else {
            System.out.println("File created");
        }
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        for (int i = 0; i < 12; i++) {
            int birthYear = random.nextInt(2010 - 1990 + 1) + 1990;
            int birthMonth = random.nextInt(12) + 1;
            int birthDay = random.nextInt(31) + 1;
            Date date = new Date(birthYear - 1900, birthMonth - 1, birthDay);
            String formattedDate = dateFormat.format(date);
            output.print(formattedDate + "\n");
        }
        output.close();
        ReadFile(file);


//        try (FileOutputStream fos = new File OutputStream(filePath)) {
//            Random random = new Random();
//
//            for (int i = 0; i < 12; i++) {
//                int birthYear = random.nextInt(1990 - 2010 + 1) + 2010;
//                int birthMonth = random.nextInt(12) + 1;
//                int birthDay = random.nextInt(31) + 1;
//                Date date = new Date(birthYear - 1900, birthMonth - 1, birthDay);
//                fos.write(date);
//            }
//
//            System.out.println("Random values have been written to " + filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String filePath = "dates.txt";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//
//            while ((line = br.readLine()) != null) {
//                String[] dateParts = line.split("\\s+");
//
//                for (String dateStr : dateParts) {
//                    try {
//                        Date date = dateFormat.parse(dateStr);
//                        int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
//                        if (month >= 3 && month <= 5) {
//                            System.out.println("Found spring date: " + dateStr);
//                        }
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
