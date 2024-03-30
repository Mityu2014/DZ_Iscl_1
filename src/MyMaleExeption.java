public class MyMaleExeption extends IllegalArgumentException {
    public MyMaleExeption(String male) {
        super("Указанный пол " + male + " не соответсвует формату f или m");
    }
}
