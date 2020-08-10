package hw5;

import javax.xml.namespace.QName;

public class TestOp {

    public static void main(String[] args) {
        doEmployeeList();
    }

    public static void doEmployeeList() {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", 892312312, 30000, 30);
        persArray[1] = new Employee("Sadikov Andrey", "Programmer", "andrey228@mail.com", 892706312, 90000, 41);
        persArray[2] = new Employee("DJ Cold", "Janitor", "coolman317@mailbox.com", 892012666, 2000000, 63);
        persArray[3] = new Employee("Clara Day", "Secretary", "lolobab@mail.com", 892209705, 20000, 25);
        persArray[4] = new Employee("Jack Sparrow", "Top-manager", "evil999@gmail.com", 890010000, 3000000, 43);
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > 40) {
                persArray[i].info();
            }
        }
    }
}
