public class Complex<T> {
    private T real;
    private T imaginary;

    public Complex(T real, T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public T getReal() {
        return real;
    }

    public void setReal(T real) {
        this.real = real;
    }

    public T getImaginary() {
        return imaginary;
    }

    public void setImaginary(T imaginary) {
        this.imaginary = imaginary;
    }

    public Complex<T> add(Complex<T> other) {
        T newReal = add(this.real, other.getReal());
        T newImaginary = add(this.imaginary, other.getImaginary());
        return new Complex<>(newReal, newImaginary);
    }

    public Complex<T> subtract(Complex<T> other) {
        T newReal = subtract(this.real, other.getReal());
        T newImaginary = subtract(this.imaginary, other.getImaginary());
        return new Complex<>(newReal, newImaginary);
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    private T add(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf((Integer) a + (Integer) b);
        } else if (a instanceof Double) {
            return (T) Double.valueOf((Double) a + (Double) b);
        } else {
            throw new UnsupportedOperationException("Unsupported type");
        }
    }

    private T subtract(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf((Integer) a - (Integer) b);
        } else if (a instanceof Double) {
            return (T) Double.valueOf((Double) a - (Double) b);
        } else {
            throw new UnsupportedOperationException("Unsupported type");
        }
    }

    public static void main(String[] args) {
        Complex<Integer> complex1 = new Complex<>(2, 3);
        Complex<Integer> complex2 = new Complex<>(1, 2);

        Complex<Integer> sum = complex1.add(complex2);
        Complex<Integer> difference = complex1.subtract(complex2);

        complex1.print();
        complex2.print();
        sum.print();
        difference.print();
    }
}