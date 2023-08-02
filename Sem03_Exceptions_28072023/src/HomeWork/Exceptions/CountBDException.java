package HomeWork.Exceptions;

public class CountBDException extends IllegalArgumentException {
    private int needed;
    private int entered;
    public CountBDException(int needed, int entered) {
        super("Количество полей дня рождения не соответствует необходимому\n  Введено " + entered + ", необходимо " + needed);
        this.needed = needed;
        this.entered = entered;
    }
}
