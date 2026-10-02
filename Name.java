// Задача 1.3. Имя: фамилия, личное имя и отчество.
// Любая часть может быть не задана (null), тогда она просто не выводится.
public class Name {

    private String lastName;   // фамилия
    private String firstName;  // личное имя
    private String middleName; // отчество

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        String result = "";

        if (lastName != null) {
            result = result + lastName + " ";
        }
        if (firstName != null) {
            result = result + firstName + " ";
        }
        if (middleName != null) {
            result = result + middleName + " ";
        }

        // trim() убирает лишний пробел в конце строки
        return result.trim();
    }
}
