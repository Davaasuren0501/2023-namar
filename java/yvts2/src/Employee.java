class Employee {
    private String name;
    private String email;
    private Double salary;
    private Boolean gender;

    public Employee(String name, String email, Double salary, Boolean gender) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Double getSalary() {
        return salary;
    }

    public Boolean getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}