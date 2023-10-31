import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shalgalt {
    public Shalgalt() {
        List<Employee> employees = CreateRandomObject();
        Savetofile(employees);
    }

    public List<Employee> CreateRandomObject() {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();

        String[] names = {"John Doe", "Jane Smith", "Bob Johnson", "Alice Brown", "David Lee"};
        String[] employeeCodes = {"123", "234", "1243", "363", "785"};

        for (int i = 0; i < 10; i++) {
            String name = names[random.nextInt(names.length)];
            int salary = random.nextInt(100000) + 30000;
            String employeeCode = employeeCodes[random.nextInt(employeeCodes.length)];

            Employee employee = new Employee(name, salary, employeeCode);
            employees.add(employee);
        }

        return employees;
    }
    public void Savetofile(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            oos.writeObject(employees);
            System.out.println("save to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Shalgalt object01 = new Shalgalt();
    }
}