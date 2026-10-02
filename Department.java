import java.util.ArrayList;

// Отдел: название, начальник и список всех сотрудников.
// Задача 2.4: название и начальник.
// Задача 3.4: список сотрудников, чтобы через любого сотрудника узнать весь отдел.
public class Department {

    private String name;
    private Employee boss;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.boss = null; // начальника пока нет
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Вызывается из конструктора Employee, вручную вызывать не нужно
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public String toString() {
        String bossName = "не назначен";
        if (boss != null) {
            bossName = boss.getName();
        }
        return "Отдел " + name + ", начальник: " + bossName + ", сотрудников: " + employees.size();
    }
}
