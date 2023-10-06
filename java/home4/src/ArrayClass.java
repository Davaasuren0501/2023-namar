public class ArrayClass {
    private int[] array;
    private int size;
    private int capacity;

    public ArrayClass() {
        this.capacity = 5;
        this.array = new int[capacity];
        this.size = 0;
    }

    public void add(int value1, int value2) {
        if (size == capacity) {
            increaseCapacity();
        }
        try {
            array[size] = Math.addExact(value1, value2);
            size++;
        } catch (ArithmeticException e) {
            System.out.println("OVERFLOW");
        }
    }

    public int at(int index) {
        if (index < 0 || index >= size) {
            System.out.println("ERROR: Index out of bounds.");
            return 0;
        }

        return array[index];
    }

    private void increaseCapacity() {
        int newCapacity = capacity * 2;
        int[] newArray = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
        capacity = newCapacity;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public static void main(String[] args) {
        ArrayClass arr = new ArrayClass();

        arr.add(1, 2);
        arr.add(Integer.MAX_VALUE, 1);
        arr.add(4, 5);
        arr.add(1, 5);
        arr.add(7, 7);

        System.out.println("Array size: " + arr.size());
        System.out.println("Array capacity: " + arr.capacity());

        for (int i = 0; i < arr.size(); i++) {
            System.out.println("Element at index " + i + ": " + arr.at(i));
        }
        System.out.println("Element at index 10: " + arr.at(10));
    }
}
