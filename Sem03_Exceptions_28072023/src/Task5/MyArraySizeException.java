package Task5;

public class MyArraySizeException extends IllegalArgumentException{
    private int length;
    private int realLength;

    public MyArraySizeException(int length, int realLength) {
        super("ожидается длинна массива " + length + ". Фактическая длина " + realLength);
        this.length = length;
        this.realLength = realLength;
    }

    public MyArraySizeException(int i, int length, int realLength) {
        super("ожидается длина массива " + length + ". Фактическая длина массива под индексом " + i
                + " равна " + realLength);
        this.length = length;
        this.realLength = realLength;
    }

    public int getLength() {
        return length;
    }

    public int getRealLength() {
        return realLength;
    }
}

