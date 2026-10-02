import java.util.ArrayList;
import java.util.Scanner;

// Лабораторная работа №2, вариант 7.
// Задачи: 1.3, 1.4, 2.4, 3.4, 4.4, 5.4.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Лабораторная работа №2. Вариант 7.");

        while (true) {
            printMenu();
            int choice = readInt(scanner, "Выберите пункт меню: ", 0, 8);
            System.out.println();

            if (choice == 0) {
                System.out.println("До свидания!");
                break;
            } else if (choice == 1) {
                task1_3();
            } else if (choice == 2) {
                task1_4();
            } else if (choice == 3) {
                task2_4();
            } else if (choice == 4) {
                task3_4();
            } else if (choice == 5) {
                task4_4();
            } else if (choice == 6) {
                task5_4();
            } else if (choice == 7) {
                enterOwnTime(scanner);
            } else if (choice == 8) {
                task1_3();
                task1_4();
                task2_4();
                task3_4();
                task4_4();
                task5_4();
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("========== МЕНЮ ==========");
        System.out.println("1 - Задача 1.3. Имена");
        System.out.println("2 - Задача 1.4. Время");
        System.out.println("3 - Задача 2.4. Сотрудники и отделы");
        System.out.println("4 - Задача 3.4. Список сотрудников отдела");
        System.out.println("5 - Задача 4.4. Создаём Время");
        System.out.println("6 - Задача 5.4. Сколько сейчас времени?");
        System.out.println("7 - Ввести своё время с клавиатуры");
        System.out.println("8 - Показать все задачи сразу");
        System.out.println("0 - Выход");
    }

    // Задача 1.3. Имена
    private static void task1_3() {
        System.out.println("--- Задача 1.3. Имена ---");

        Name cleopatra = new Name(null, "Клеопатра", null);
        Name pushkin = new Name("Пушкин", "Александр", "Сергеевич");
        Name mayakovsky = new Name("Маяковский", "Владимир", null);

        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);
        System.out.println();
    }

    // Задача 1.4. Время
    private static void task1_4() {
        System.out.println("--- Задача 1.4. Время ---");

        Time first = new Time(10);
        Time second = new Time(10000);
        Time third = new Time(100000);

        System.out.println("10 секунд     -> " + first);
        System.out.println("10000 секунд  -> " + second);
        System.out.println("100000 секунд -> " + third);
        System.out.println();
    }

    // Задача 2.4. Сотрудники и отделы
    private static void task2_4() {
        System.out.println("--- Задача 2.4. Сотрудники и отделы ---");

        // 1. Создаём отдел IT и трёх сотрудников в нём
        Department it = new Department("IT");
        Employee petrov = new Employee("Петров", it);
        Employee kozlov = new Employee("Козлов", it);
        Employee sidorov = new Employee("Сидоров", it);

        // 2. Делаем Козлова начальником
        it.setBoss(kozlov);

        // 3. Выводим всех троих
        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);
        System.out.println();
    }

    // Задача 3.4. Список сотрудников отдела через ссылку на сотрудника
    private static void task3_4() {
        System.out.println("--- Задача 3.4. Список сотрудников отдела ---");

        Department it = new Department("IT");
        Employee petrov = new Employee("Петров", it);
        Employee kozlov = new Employee("Козлов", it);
        Employee sidorov = new Employee("Сидоров", it);
        it.setBoss(kozlov);

        System.out.println("Сотрудники отдела, где работает " + petrov.getName() + ":");
        printEmployees(petrov.getDepartmentEmployees());

        System.out.println("Добавим в отдел нового сотрудника Иванова.");
        new Employee("Иванов", it);

        System.out.println("Сотрудники отдела, где работает " + sidorov.getName() + ":");
        printEmployees(sidorov.getDepartmentEmployees());

        System.out.println(it);
        System.out.println();
    }

    private static void printEmployees(ArrayList<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + employees.get(i).getName());
        }
    }

    // Задача 4.4. Создаём Время двумя способами
    private static void task4_4() {
        System.out.println("--- Задача 4.4. Создаём Время ---");

        Time fromSeconds = new Time(10000);
        Time fromParts = new Time(2, 3, 5);

        System.out.println("10000 секунд               -> " + fromSeconds);
        System.out.println("2 часа, 3 минуты, 5 секунд -> " + fromParts);
        System.out.println();
    }

    // Задача 5.4. Сколько сейчас времени?
    private static void task5_4() {
        System.out.println("--- Задача 5.4. Сколько сейчас времени? ---");

        Time first = new Time(34056);
        Time second = new Time(4532);
        Time third = new Time(123);

        System.out.println("Время 34056 (" + first + "): часов = " + first.getHours());
        System.out.println("Время 4532 (" + second + "): минут = " + second.getMinutes());
        System.out.println("Время 123 (" + third + "): секунд = " + third.getSeconds());
        System.out.println();
    }

    // Ввод времени с клавиатуры с проверкой
    private static void enterOwnTime(Scanner scanner) {
        System.out.println("--- Своё время ---");

        int hours = readInt(scanner, "Часы (0-23): ", 0, 23);
        int minutes = readInt(scanner, "Минуты (0-59): ", 0, 59);
        int seconds = readInt(scanner, "Секунды (0-59): ", 0, 59);

        Time time = new Time(hours, minutes, seconds);

        System.out.println("Время: " + time);
        System.out.println("С начала суток прошло секунд: " + time.getTotalSeconds());
        System.out.println("Час: " + time.getHours()
                + ", минута: " + time.getMinutes()
                + ", секунда: " + time.getSeconds());
    }

    // Читает целое число от min до max. Пока ввод неверный, просит ещё раз.
    private static int readInt(Scanner scanner, String message, int min, int max) {
        while (true) {
            System.out.print(message);

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Нужно ввести целое число.");
                scanner.next(); // выбрасываем неправильный ввод
                continue;
            }

            int number = scanner.nextInt();

            if (number < min || number > max) {
                System.out.println("Ошибка! Число должно быть от " + min + " до " + max + ".");
                continue;
            }

            return number;
        }
    }
}
