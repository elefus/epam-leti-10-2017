package com.epam.jf.common.classwork.lesson11.generics;

import java.util.*;

public class Task18 {

    // TODO метод сортировки, принимающий компаратор, умеющий сравнивать людей по именам и список сотрудников
    private static void sortByName(Comparator<? super Person> comparator, List<? extends Employee> list) {
            Collections.sort(list, comparator);
    }

    // TODO метод сортировки, принимающий компаратор, умеющий сравнивать объекты по весу и список сотрудников
    private static void sortByWeight(Comparator<? super PhysicalObject> comparator, List<? extends Employee> list) {
        Collections.sort(list, comparator);
    }

    // TODO метод, выбирающий работников у которых зп больше 65000 из исходного списка и помещающий в список сотрудников
    private static void selectEmployeesWithSalaryGreaterThen65000(List<? extends Employee> src, List<? super Employee> dst) {
        for (Employee employee : src) {
            if (employee.getSalary() > 65000) {
                dst.add(employee);
            }
        }
    }

    // TODO метод, выбирающий объекты у которых вес меньше 65 из исходного списка и помещающий в список физических объектов
    private static void selectObjectsWithWeightLessThen65(List<? extends PhysicalObject> src, List<? super PhysicalObject> dst) {
        for (PhysicalObject physicalObject : src) {
            if (physicalObject.getWeight() < 65) {
                dst.add(physicalObject);
            }
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(90, "Дмитрий", "Светличный", 80000),
                new Employee(60, "Алексей", "Мельников", 60000),
                new Employee(81, "Семен", "Паршин", 70000)
        );

        Comparator<Person> comparatorByName = new ComparatorByName();
        sortByName(comparatorByName, employees);
        System.out.println(employees);

        Comparator<PhysicalObject> comparatorByWeight = new ComparatorByWeight();
        sortByWeight(comparatorByWeight, employees);
        System.out.println(employees);

        List<Object> richGuys = new ArrayList<>();
        selectEmployeesWithSalaryGreaterThen65000(employees, richGuys);
        System.out.println(richGuys);

        List<PhysicalObject> lightObjects = new ArrayList<>();
        selectObjectsWithWeightLessThen65(employees, lightObjects);
        System.out.println(lightObjects);
    }
}

abstract class PhysicalObject {

    private final double weight;

    PhysicalObject(double weight) {
        this.weight = weight;
    }

    /** @return Вес. */
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.valueOf(weight);
    }
}

class Person extends PhysicalObject {

    private final String firstName;
    private final String lastName;

    Person(double weight, String firstName, String lastName) {
        super(weight);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /** @return Имя. */
    public String getFirstName() {
        return firstName;
    }

    /** @return Фамилия. */
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return super.toString() + " " + firstName + " " + lastName;
    }
}

class Employee extends Person {

    private int salary;

    public Employee(double weight, String firstName, String lastName, int salary) {
        super(weight, firstName, lastName);
        this.salary = salary;
    }

    /** @return Зарплата. */
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + " " + salary;
    }
}
