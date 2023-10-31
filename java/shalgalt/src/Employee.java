public class Employee {
    private String name;
    private int salary;
    private String employeeCode;

    public Employee(String name, int salary, String employeeCode) {
        this.name = name;
        this.salary = salary;
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 50000, "EMP123");
        System.out.println(employee.toString());
    }
}
