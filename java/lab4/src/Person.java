import java.io.EOFException;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Person {
    String name;
    Date date;

    static ArrayList<Person> arrayList = new ArrayList<>();
    public  Person( String name , Date date) {
            this.name = name;
            this.date =  date;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public static  void ReadFile()  {
        java.io.File file = new java.io.File("person.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            while (input.hasNext()) {
                String string = input.nextLine();
                String[] data = string.split(" ");
                String dateOfBirthString = data[1] + " " + data[2] + " " + data[3];
                Person person = new Person( data[0], dateFormat.parse(dateOfBirthString));
                arrayList.add(person);
            }
            for (Person p: arrayList) {
                System.out.println(p.getName() + " " + p.getDate());
            }
        } catch (FileNotFoundException | ParseException e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }

    public static void main(String[] args){
        ReadFile();
    }
}
