package hw5;

public class Employee {
String name;
String position;
String email;
int phoneNum, salary, age;

Employee(String name, String position, String email, int phoneNum, int salary, int age) {
    this.name = name;
    this.position = position;
    this.email = email;
    this.phoneNum = phoneNum;
    this.salary = salary;
    this.age = age;

}

public void info() {
    System.out.println("============================================================");
    System.out.println(String.format("Ф.И.О: %s\n" +
            "Должность: %s\n" +
            "Эл.почта: %s\n" +
            "Номер телефона: %s\n" +
            "Зарплата: %s\n" +
            "Возраст: %s\n",
            name, position, email, phoneNum, salary, age ));

}

}
