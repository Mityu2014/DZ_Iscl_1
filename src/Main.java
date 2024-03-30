
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    //Иванов Иван Иванович 01.01.2024 123456 m
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные разделенные пробелом: Фамилия Имя Отчество дата _ рождения номер _ телефона пол: ");
        String next = scanner.nextLine();
        String[] splitData = next.split(" ");
        boolean flag = true;
        // Проверка на корректное количество введенных данных
        if (splitData.length != 6) {
            throw new MyArraySizeExeption(splitData.length);
        }
        // Проверка на корректное введение даты
        try {
            getDateFromString(splitData[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }catch (DateTimeParseException e) {
            System.out.println("Exeption: Введенная дата " + splitData[3] + " не соответствует формату даты dd.mm.yyyy");
            flag = false;
        }
        // Проверка на корректное введение телефона
        try {
            Integer.parseInt(splitData[4]);
        } catch (NumberFormatException e){
            System.out.println("Exeption: Номер телефона " + splitData[4] + " введен некорректно");
            flag = false;
        }
        // Проверка на корректное введение пола f или m
        if (splitData[5].length() > 1 || (!splitData[5].equals("m") && !splitData[5].equals("f"))){
            flag = false;
            throw new MyMaleExeption (splitData[5]);
        }
        if (flag) {
            // собираем строку для записи в файл
            String person = "<";
            for (int i = 0; i < splitData.length - 1; i++) {
                person = person + splitData[i] + "> <";
            }
            person = person + splitData[5] + ">" + "\n";
            // проверка на корректную работу с файлом
            String fn = splitData[0] + ".txt";
            try {
                fileNotFound(fn, person);
            } catch (NonExistedFileExeption e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileNotFound (String pathFile,String person) throws NonExistedFileExeption {
        try (FileWriter fw = new FileWriter(pathFile, true);){
            fw.write(person);
            fw.flush();
        }catch (IOException e){
            throw new NonExistedFileExeption();
        }
    }

        public static LocalDate getDateFromString (String string, DateTimeFormatter format){
            LocalDate date = LocalDate.parse(string, format);
            return date;
        }
}
