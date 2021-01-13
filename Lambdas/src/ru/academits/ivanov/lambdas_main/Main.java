package ru.academits.ivanov.lambdas_main;

import ru.academits.ivanov.person.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> peoples = Arrays.asList(
                new Person("Иван", 50),
                new Person("Алексей", 13),
                new Person("Василий", 24),
                new Person("Костя", 3),
                new Person("Марина", 19),
                new Person("Иван", 25),
                new Person("Владимир", 15),
                new Person("Кирилл", 13),
                new Person("Василий", 65),
                new Person("Светлана", 18),
                new Person("Никита", 32),
                new Person("Валентин", 43),
                new Person("Ирина", 26),
                new Person("Владлен", 28)
        );

        System.out.println("a) Получить список уникальных имен");

        List<String> uniqueNames = peoples.stream()
                .distinct()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(uniqueNames);
        System.out.println();

        System.out.println("б) Вывести список уникальных имен");

        String uniqueNamesString = uniqueNames.stream()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(uniqueNamesString);
        System.out.println();

        System.out.println("в) получить список людей младше 18, посчитать для них средний возраст");

        List<Person> peopleUnder18Years = peoples.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());

        System.out.println(peopleUnder18Years);

        OptionalDouble averageAge = peopleUnder18Years.stream()
                .mapToDouble(Person::getAge)
                .average();

        averageAge.ifPresent(a -> System.out.println("Средний возраст людей младше 18 лет: " + a));
        System.out.println();

        System.out.println("г) при помощи группировки получить Map, в котором ключи имена, а значения – средний возраст");

        Map<String, Double> averageAgeByName = peoples.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));

        averageAgeByName.forEach((name, age) -> System.out.printf("Имя: %s; Средний возраст: %.1f%n", name, age));
        System.out.println();

        System.out.println("д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста");

        List<Person> peopleAgedFrom20To45 = peoples.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .collect(Collectors.toList());

        System.out.println(peopleAgedFrom20To45);
        System.out.println();

        System.out.println("Задача 2. Создать бесконечный поток корней чисел");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число элементов которое нужно вычислить:");
        int numbersCount = scanner.nextInt();

        Stream.iterate(0, x -> x + 1)
                .mapToDouble(Math::sqrt)
                .limit(numbersCount)
                .forEach(x -> System.out.printf("%.2f ", x));
    }
}