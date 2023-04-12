package WorkWithData;

import java.util.Scanner;

public class Main {
    private static Scanner str = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Введите фамилию, имя, отчество и дату рождения человека");
        String personInfo = str.nextLine();

        WorkData data = new WorkData();
        data.parsing(personInfo);
    }
}