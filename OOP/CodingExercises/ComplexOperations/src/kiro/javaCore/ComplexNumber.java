package kiro.javaCore;

public class ComplexNumber {
    // complex number is represented by the form of (a + bi) where a and b
    //  are real numbers and i is a solution of equation x^2 = -1;
    // a is called real part and b is called imaginary part;
    // note: to add or subtract complex numbers, just perform the operation on
    //  corresponding real and imaginary parts;

    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    public void add(ComplexNumber obj) {
        this.real += obj.real;
        this.imaginary += obj.imaginary;
    }

    public void subtract(double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public void subtract(ComplexNumber obj) {
        this.real -= obj.real;
        this.imaginary -= obj.imaginary;
    }
}
