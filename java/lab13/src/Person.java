import java.util.*;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person("Temka", 25),
                new Person("Davka", 30),
                new Person("Bayka", 22)
        );

        List<Person> sortedList = personList.stream()
                .sorted(Comparator.comparingInt(person -> person.getName().length()))
                .collect(Collectors.toList());

        sortedList.forEach(person -> System.out.println("Name: " + person.getName() + ", Age: " + person.getAge()));

        Comparator<Person> personAgeComparator = Comparator.comparingInt(Person::getAge);
        Collections.sort(personList, personAgeComparator);
        Person personOld = personList.get(personList.size() - 1);
        System.out.println("Old person");
        System.out.println("Name: " + personOld.getName() + ", Age: " + personOld.getAge());
    }
}
