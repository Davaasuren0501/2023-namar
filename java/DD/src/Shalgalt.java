import java.io.*;
import java.util.*;

public class Shalgalt {
    public Shalgalt() {
        List<Employee> employees = CreateRandomObject();
        Savetofile(employees);
        TreeMap<String, Employee> data = ReadtoFile();
        List<Employee> employeeList = new ArrayList<>(data.values());
        SortName(employeeList);
        SortSalary(employeeList);
        SortCode(employeeList);
    }

    public void SortName(List<Employee> employeeList){

        employeeList.sort(Comparator.comparing(Employee::getName));

        TreeMap<String, Employee> namesort = new TreeMap<>();
        for (Employee employee : employeeList) {
            namesort.put(employee.getName(), employee);
        }
        System.out.println( "Sort employee name: " );
        for (Map.Entry<String, Employee> entry : namesort.entrySet()) {
            System.out.println("Employee Name: " + entry.getKey() + ", Employee: " + entry.getValue());
        }
    }

    public void SortSalary(List<Employee> employeeList){

        employeeList.sort(Comparator.comparing(Employee::getSalary));
        TreeMap<String, Employee> sortsalary = new TreeMap<>();
        for (Employee employee : employeeList) {
            sortsalary.put(employee.getName(), employee);
        }

        System.out.println( "Sort employee salary: " );
        for (Map.Entry<String, Employee> entry : sortsalary.entrySet()) {
            System.out.println(" Employee: " + entry.getValue());
        }
    }

    public void SortCode(List<Employee> employeeList){

        employeeList.sort(Comparator.comparing(Employee::getEmployeeCode));

        TreeMap<String, Employee> codesort = new TreeMap<>();
        for (Employee employee : employeeList) {
            codesort.put(employee.getEmployeeCode(), employee);
        }

        System.out.println( "Sort employee code: " );
        for (Map.Entry<String, Employee> entry : codesort.entrySet()) {
            System.out.println("Employee code: " + entry.getKey() + ", Employee: " + entry.getValue());
        }
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

    public TreeMap<String, Employee> ReadtoFile(){
        TreeMap<String, Employee> employeeMap = new TreeMap<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat")) ) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            for (Employee employee : employees) {
                employeeMap.put(employee.getEmployeeCode(), employee);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employeeMap;
    }
    public static void main(String[] args) {
        Shalgalt object01 = new Shalgalt();
    }
}