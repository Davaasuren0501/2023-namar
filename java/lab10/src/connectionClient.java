import java.io.*;
import java.net.*;
import java.util.*;
class connectionClient{
    public static void main(String[] args){
        try{
            InetAddress serverHost = InetAddress.getByName("127.0.0.1");
            int serverPortNum = Integer.parseInt("5000");

            Socket clientSocket = new Socket(serverHost, serverPortNum);

            Scanner input = new Scanner(System.in);
            System.out.print("Enter the number of students: ");
            int numberOfStudents = input.nextInt();

            ArrayList<Student> list = new ArrayList<>();

            for (int i = 0; i < numberOfStudents; i++) {

                System.out.print("Enter student id " + (i+1) + " :" );
                String id = input.next( );
                System.out.print("Enter student name " + (i+1) + " :");
                String name = input.next( );
                System.out.print("Enter student gpa " + (i+1) + " :");
                double gpa = input.nextDouble( );
                Student objectSend = new Student( id, name,gpa );
                list.add(objectSend);
            }
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream( ));
            oos.writeObject(list);
            oos.flush( );
            clientSocket.close( );
        }
        catch(Exception e){e.printStackTrace( );}
    }
}