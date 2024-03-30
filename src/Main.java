
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
        String[] split = next.split(" ");
        if (split.length != 6) {
            throw new MyArraySizeExeption(split.length);
        }
        String name = split[0]; // Имя
        String dateString = split[3];
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate date = getDateFromString(dateString, format); // Дата
        }catch (DateTimeParseException e) {
            System.out.println("Exeption: Введенная дата " + dateString + " не соответствует формату даты dd.mm.yyyy");
        }
        try {
            int numberTel = Integer.parseInt(split[4]); // Телефон
        } catch (NumberFormatException e){
            System.out.println("Exeption: Номер телефона " + split[4] + " введен некорректно");
        }
        char male = split[5].charAt(0);
        if (split[5].length() > 1 || (male != 'm' && male != 'f')){
            throw new MyMaleExeption (male);
        }

        String person = "<";
        for (int i = 0; i < split.length - 1; i++) {
            person =person + split[i] +"> <";
        }
        person = person + split[5] +">" +"\n";
        String fn = name + ".txt";
        FileWriter fw = null;
        try {
            fw = new FileWriter(fn, true);
            fw.write(person);
            fw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




        public static LocalDate getDateFromString (String string, DateTimeFormatter format){
            LocalDate date = LocalDate.parse(string, format);
            return date;
        }

}
