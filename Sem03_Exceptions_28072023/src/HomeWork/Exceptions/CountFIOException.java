package HomeWork.Exceptions;

public class CountFIOException extends IllegalArgumentException{
    private int needed;
    private int entered;

    public CountFIOException(int needed, int entered) {
        super("Количество параметров ФИО не соответствует необходимому\n  Введено " + entered + ", необходимо " + needed);
        this.needed = needed;
        this.entered = entered;

    }
}
