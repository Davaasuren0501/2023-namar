public class TestGeometricObject {
    public static void main(String[] args) {
        GeometricObject[] objects = new GeometricObject[5];

        objects[0] = new Square(5);
        objects[1] = new Square(6);
        objects[2] = new Square(7);
        objects[3] = new Square(8);
        objects[4] = new Square(9);
        for (int i = 0; i < 5; i++) {
            objects[i] = new Square(i);
            ((Colorable) objects[i]).howToColor();
        }
    }
}
