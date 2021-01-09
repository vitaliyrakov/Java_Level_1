public class Main {
    public static void main(String[] args) {
        /*4. Создать массив из 5 сотрудников
        Пример:
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person(...);
        ...
        persArray[4] = new Person(...);         */

        Employee[] emplAArray = new Employee[5];
        emplAArray[0] = new Employee("Петров B.B", "Java Developer", "petrov.vv@gmail.com", "+79112553131", 120000, 30);
        emplAArray[1] = new Employee("Иванов И.И", "QA", "ivanov.ii@gmail.com", "+79112555689", 100000, 35);
        emplAArray[2] = new Employee("Сидоров С.С", "Java Architect", "sidorov.ss@gmail.com", "+79112553245", 200000, 45);
        emplAArray[3] = new Employee("Смирнов С.И", "Java Developer", "smirnov.si@gmail.com", "+79112556458", 120000, 40);
        emplAArray[4] = new Employee("Трунов В.М", "Java Developer", "trunov.vm@gmail.com", "+79112558712", 120000, 50);

        //5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        for (Employee e: emplAArray)
            if (e.getAge()>40) e.getInfo();
    }
}
