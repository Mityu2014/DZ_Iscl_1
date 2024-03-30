import java.io.FileNotFoundException;

public class NonExistedFileExeption extends FileNotFoundException {

    public NonExistedFileExeption() {
        super("Ошибка при работе с файлом");
    }
}
