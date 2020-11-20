package ru.academits.ivanov.vector.vector_methods;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Длина вектора должна быть больше нуля");
        }

        this.components = new double[n];
    }

    public Vector(Vector vector) {
        if (vector.components.length <= 0) {
            throw new IllegalArgumentException("Длина вектора должна быть больше нуля");
        }

        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Длина вектора должна быть больше нуля");
        }

        this.components = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Длина вектора должна быть больше нуля");
        }

        this.components = Arrays.copyOf(array, n);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(components[i]);
            if (i == components.length - 1)
                return b.append('}').toString();
            b.append(", ");
        }
    }

    public int getSize() {
        return components.length;
    }

    public void sum(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void difference(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiplicationOnScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void reversalVector() {
        for (int i = 0; i < components.length; i++) {
            components[i] *= -1;
        }
    }

    public double getVectorLength() {
        double VectorLength = 0;

        for (double component : components) {
            VectorLength += component * component;
        }

        return Math.sqrt(VectorLength);
    }

    public double getComponent(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Индекс компонента должна быть больше нуля");
        }

        if (i > components.length) {
            throw new IllegalArgumentException("Индекс компонента больше длинны вектора");
        }

        return components[i];
    }

    public void setComponent(int i, double newComponent) {
        if (i <= 0) {
            throw new IllegalArgumentException("Индекс компонента должна быть больше нуля");
        }

        if (i > components.length) {
            throw new IllegalArgumentException("Индекс компонента больше длинны вектора");
        }

        components[i] = newComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Vector v = (Vector) o;
        return getSize() == v.getSize() && Arrays.equals(components, v.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        vector.sum(vector2);
        return vector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        vector.difference(vector2);
        return vector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        if (vector1.components.length < vector2.components.length) {
            vector1.components = Arrays.copyOf(vector1.components, vector2.components.length);
        }

        for (int i = 0; i < vector1.components.length; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}