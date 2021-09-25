package hw8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //1 Задание
        //Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто
        //встречающееся

        List<String> arr = new ArrayList<>();
        arr.add("1");
        arr.add("2");
        arr.add("2");
        arr.add("1");
        arr.add("1");
        arr.add("1");
        arr.add("1");
        arr.add("1");
        arr.add("a3r");
        arr.add("a3r");
        arr.add("a3r");
        arr.add("a3r");
        arr.add("a3r");
        arr.add("a3r");
        arr.add("a3r");
        arr.add("a3r");
        Map<String, Long> wordsByCount = arr.stream()
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        String prevalentWord = wordsByCount.entrySet().stream()
                .max(Map.Entry.comparingByValue()).orElseThrow(()->new RuntimeException("Нет элементов")).getKey();

        System.out.println(prevalentWord);

        //2 Задание
        //Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
        //среднюю зарплату сотрудника

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Илюха (Крутой)",23,110));
        employeeList.add(new Employee("Лев",24,75));
        employeeList.add(new Employee("Серега",23,120));
        employeeList.add(new Employee("Игорь",228,228));
        double avgSalary = employeeList.stream().collect(Collectors.averagingInt(Employee::getSalary));
        System.out.println(avgSalary);

        //3 Задание
        //Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
        //сотрудников и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут:
        //имя1, имя2, имяN;”
        findNOlderEmployee(employeeList,2);
    }

    public static void findNOlderEmployee(List<Employee> employeeArrayList, int n){
        String findNOlderEmployeeArr = employeeArrayList.stream().sorted((e1, e2)->e2.getAge()-e1.getAge())
                .map(Employee::getName).limit(n)
                .collect(Collectors.joining(",","Cамых старших сотрудников зовут:"," "));
                System.out.println(findNOlderEmployeeArr);
    }
}
