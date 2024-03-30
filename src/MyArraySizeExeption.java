public class MyArraySizeExeption extends ArrayIndexOutOfBoundsException {
    public MyArraySizeExeption(int length) {
            super("Колличество введенных данных " + length + ", а должно быть 6");
    }
}
