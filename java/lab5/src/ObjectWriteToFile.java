import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectWriteToFile {

    ObjectWriteToFile() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota prius 10", "УБС 1234", "Davaasuren"));
        cars.add(new Car("Toyota prius 11", "ХӨВ 0983", "Temuulen"));
        cars.add(new Car("Toyota prius 20", "БАЗ 5671", "Otgonnaran"));
        cars.add(new Car("Toyota prius 30", "ОРХ 0976", "Naraa"));
        cars.add(new Car("Toyota prius 30", "УБС 4523", "Bar"));
        writeObjectToFile(cars, "cars.dat");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Mashinii neriig oruul: ");
        String markInput = scanner.nextLine();
        List<Car> readCars = readObjectToFile("cars.dat");
        printEqualCarMark(readCars,markInput );
    }
    public static void main(String[] args) {
        new ObjectWriteToFile();
    }

    public void printEqualCarMark(List<Car> cars, String MarkName){
        for (Car car : cars) {
            if (car.getMark().contains(MarkName)) {
                System.out.println( "registration number: " + car.getRegistrationNumber() + " owner: " + car.getOwnerName());
            }
        }
    }

    private void writeObjectToFile(List<Car> cars, String fileName) {
        try (ObjectOutputStream outC = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outC.writeObject(cars);
            System.out.println("Saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Car> readObjectToFile(String fileName) {
        List<Car> cars = new ArrayList<>();
        try (ObjectInputStream outC = new ObjectInputStream(new FileInputStream(fileName))) {
            cars = (List<Car>) outC.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
