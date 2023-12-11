import java.io.*;
import java.net.*;
import java.util.ArrayList;

class connectionServer{
    public static void main(String[] args){
        try{

            ServerSocket connectionSocket = new ServerSocket(5000);

            Socket dataSocket = connectionSocket.accept( );
            ObjectInputStream ois = new ObjectInputStream(dataSocket.getInputStream( ));

            ArrayList<Student> studentList = (ArrayList<Student>) ois.readObject( );
            System.out.println("============= Receive student objects =============");
            Student maxGpaStudent = studentList.get(0);
            for (Student ed_student : studentList) {
                if (ed_student.getGpa() > maxGpaStudent.getGpa()) {
                    maxGpaStudent = ed_student;
                }
                System.out.println("Student id : "+ed_student.getId( ));
                System.out.println("Student name : "+ed_student.getName( ));
                System.out.println("Student gpa : "+ed_student.getGpa( ));
            }
            System.out.println("============= Max gpa student =============");
            System.out.println("Student id : "+maxGpaStudent.getId( ));
            System.out.println("Student name : "+maxGpaStudent.getName( ));
            System.out.println("Student gpa : "+maxGpaStudent.getGpa( ));
            System.out.println("==========================");
            dataSocket.close( );
            connectionSocket.close( );
        }
        catch(Exception e){e.printStackTrace( );}
    }
}