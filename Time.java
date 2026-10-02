// Время суток. Хранится как количество секунд с начала суток.
// Задача 1.4: вывод в виде "Ч:ММ:СС", лишние сутки отбрасываются.
// Задача 4.4: два конструктора, присвоение поля только в одном месте.
// Задача 5.4: методы getHours(), getMinutes(), getSeconds().
public class Time {

    private static final int SECONDS_IN_DAY = 24 * 60 * 60; // 86400
    private static final int SECONDS_IN_HOUR = 60 * 60;     // 3600
    private static final int SECONDS_IN_MINUTE = 60;

    // final: после присвоения в конструкторе поле поменять уже нельзя
    private final int totalSeconds;

    // Время по количеству секунд с начала суток
    public Time(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    // Время по часам, минутам и секундам.
    // Сами ничего не присваиваем, а переводим всё в секунды
    // и вызываем первый конструктор через this(...)
    public Time(int hours, int minutes, int seconds) {
        this(hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds);
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    // Какой сейчас час (полные сутки отбрасываем)
    public int getHours() {
        return totalSeconds % SECONDS_IN_DAY / SECONDS_IN_HOUR;
    }

    // Сколько минут прошло с начала текущего часа
    public int getMinutes() {
        return totalSeconds % SECONDS_IN_HOUR / SECONDS_IN_MINUTE;
    }

    // Сколько секунд прошло с начала текущей минуты
    public int getSeconds() {
        return totalSeconds % SECONDS_IN_MINUTE;
    }
    // переопределяес toString иначе выведет мусор time@1b6d...
    @Override
    public String toString() {
        return getHours() + ":" + twoDigits(getMinutes()) + ":" + twoDigits(getSeconds());
    }

    // 5 -> "05", 42 -> "42"
    private String twoDigits(int number) {
        if (number < 10) {
            return "0" + number;
        }
        return "" + number;
    }
}
