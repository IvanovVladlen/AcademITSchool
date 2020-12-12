package ru.academits.ivanov.vector_main;

import ru.academits.ivanov.vector.Vector;

import static ru.academits.ivanov.vector.Vector.*;

public class Main {
    public static void main(String[] args) {
        double[] array1 = new double[]{3, 4};
        double[] array2 = new double[]{1, 15, 18, 5.5, 3, 10};
        double[] array3 = new double[]{0, 2.5, 14, 4, 0.8};

        Vector vector = new Vector(3);
        System.out.println("Печать не заполненого вектора: " + vector);

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);
        System.out.println("Печать vector1: " + vector1);
        System.out.println("Проверка на равенство vector1 и vector2: " + vector1.equals(vector2));

        Vector vector3 = new Vector(vector1);
        System.out.println("Проверка на равенство vector3 и vector1: " + vector1.equals(vector3));

        Vector vector4 = new Vector(4, array3);
        System.out.println("Печать vector4: " + vector4);

        vector1.add(vector2);
        System.out.println("Сумма vector1 и vector2: " + vector1);

        vector3.subtract(vector4);
        System.out.println("Вычитание vector4 из vector3: " + vector3);

        Vector vector5 = new Vector(new double[]{-4, 5, -2, 5.5, 32});
        System.out.println("Печать vector5: " + vector5);

        vector5.multiplyByScalar(2);
        System.out.println("Умножение vector5 на скаляр: " + vector5);

        vector5.reverse();
        System.out.println("Разворот vector5: " + vector5);

        double vectorLength = vector5.getLength();
        System.out.println("Длинна вектора vector5: " + vectorLength);

        Vector vector6 = new Vector(new double[]{5, 5.8, 4, 5.5, 3, 2});
        System.out.println("Печать vector6: " + vector6);

        double component = vector6.getComponent(4);
        System.out.println("Печать компонента вектора: " + component);

        vector6.setComponent(2, 44.4);
        System.out.println("Обновление компонента вектора: " + vector6);

        Vector vector7 = new Vector(new double[]{1, 15, 4, 4, 3, 2});
        System.out.println("Печать vector7: " + vector6);

        Vector vector8 = new Vector(new double[]{5, 8, 4, 5.5, 3, 4, 2.15});
        System.out.println("Печать vector8: " + vector6);

        Vector vector9 = getSum(vector7, vector8);
        System.out.println("Сумма vector7 и vector8: " + vector9);

        Vector vector10 = getDifference(vector7, vector8);
        System.out.println("Разность vector7 и vector8: " + vector10);

        double scalarProduct = getScalarProduct(vector7, vector8);
        System.out.println("Скалярное произведение векторов vector7 и vector8: " + scalarProduct);
    }
}