import java.util.ArrayList;

// Сотрудник: имя и отдел, в котором он работает.
// Задача 2.4: текстовая форма зависит от того, начальник он или нет.
// Задача 3.4: через сотрудника можно получить список всего его отдела.
public class Employee {

    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        // сотрудник сам записывает себя в список своего отдела
        department.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    // Все сотрудники того же отдела (включая этого сотрудника)
    public ArrayList<Employee> getDepartmentEmployees() {
        return department.getEmployees();
    }

    @Override
    public String toString() {
        Employee boss = department.getBoss();

        // == сравнивает ссылки: это тот же самый объект или нет
        if (boss == this) {
            return name + " начальник отдела " + department.getName();
        }
        if (boss == null) {
            return name + " работает в отделе " + department.getName() + ", начальник пока не назначен";
        }
        return name + " работает в отделе " + department.getName() + ", начальник которого " + boss.getName();
    }
}
