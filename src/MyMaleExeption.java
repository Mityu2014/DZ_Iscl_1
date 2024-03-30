public class MyMaleExeption extends IllegalArgumentException {
    public MyMaleExeption(Character male) {
        super("Указанный пол " + male + " не соответсвует формату f или m");
    }
}
