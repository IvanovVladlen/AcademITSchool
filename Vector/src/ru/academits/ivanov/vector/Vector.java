package ru.academits.ivanov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int componentsCount) {
        if (componentsCount <= 0) {
            throw new IllegalArgumentException("Components count = " + componentsCount + " <= 0");
        }

        components = new double[componentsCount];
    }

    public Vector(Vector vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Vector is null");
        }

        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Array length is 0");
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int componentsCount, double[] array) {
        if (componentsCount <= 0) {
            throw new IllegalArgumentException("Components count = " + componentsCount + " <= 0");
        }

        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        components = Arrays.copyOf(array, componentsCount);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Index = " + index + ", acceptable values: from 0 to" + (components.length - 1));
        }

        return components[index];
    }

    public void setComponent(int index, double component) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Index = " + index + ", acceptable values: from 0 to" + (components.length - 1));
        }

        components[index] = component;
    }

    public int getSize() {
        return components.length;
    }

    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void reverse() {
        multiplyByScalar(-1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (double e : components) {
            stringBuilder.append(e).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector v = (Vector) o;

        return Arrays.equals(components, v.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        vector.add(vector2);
        return vector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        vector.subtract(vector2);
        return vector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int minLength = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < minLength; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}