import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.io.FileWriter;
import java.io.IOException;

public class Bodlogo1 {

    public String nameFile = "employee.csv";
    public Double minSalary = 48000.0;

    public Bodlogo1() {
        try {
            insertData();
            List<Employee> employees = readData();
            List<Employee> lowerSalaryEmployees = getLowerSalaryEmployees(employees);
            System.out.println("------------------------------------------------------");
            System.out.println("Hamgiin baga tsalin avdag 4 ajiltanii email hayag =>  ");
            lowerSalaryEmployees.forEach(
                    e->{ System.out.println(e.getEmail());}
            );
            System.out.println("------------------------------------------------------");

            Double total = getTotalLowerSalaryFemaleEmplooyes( lowerSalaryEmployees );
            System.out.println("Hamgiin baga tsalin avdag emegtei ajilchdiin niit tsalin => " + total);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        new Bodlogo1();
    }

    public List<Employee> readData() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nameFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Employee employee = new Employee(data[0], data[1], Double.valueOf(data[2]), Boolean.valueOf(data[3]));
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
    public void insertData() throws IOException {
        List<Employee> employeelist = new ArrayList<>();
        employeelist.add(new Employee("Davaasuren", "davaasuren@gmail.com", 50000.0, true));
        employeelist.add(new Employee("Temuulen", "temuulen@gmail.com", 45000.0, false));
        employeelist.add(new Employee("Enhjin", "enhjin@gmail.com", 25000.0, false));

        employeelist.add(new Employee("Bayraa", "bayraa@gmail.com", 100000.0, false));
        employeelist.add(new Employee("Tuguldur", "tuuguu@gmail.com", 123456.9, true));
        employeelist.add(new Employee("Hashaa", "hashaa@gmail.com", 58765.0, true));
        employeelist.add(new Employee("Bilgee", "bilgee@gmail.com", 78687.0, true));

        try (FileWriter writer = new FileWriter(nameFile)) {
            for (Employee employee : employeelist) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(employee.getName()).append(",");
                stringBuilder.append(employee.getEmail()).append(",");
                stringBuilder.append(employee.getSalary()).append(",");
                stringBuilder.append(employee.getGender()).append("\n");
                writer.append(stringBuilder.toString());
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getLowerSalaryEmployees(List<Employee> employees){

        List<Employee> lowerSalaryEmployees = employees.stream()
                .filter(employee -> employee.getSalary() != null)
                .filter(employee -> employee.getSalary() <= minSalary)
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .collect(Collectors.toList());
        return lowerSalaryEmployees;
    }
    public Double getTotalLowerSalaryFemaleEmplooyes(List<Employee> lowerSalaryEmployees){

        return lowerSalaryEmployees.stream()
                .filter(employee -> employee.getGender() != null && !employee.getGender())
                .filter(employee -> employee.getSalary() != null)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

}