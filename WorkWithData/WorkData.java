package WorkWithData;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

import static java.lang.Integer.*;

/**
 * класс для обработки данных
 */
public class WorkData
{
    /**
     * функция для парсинга и обрадотки введёной строки
     * @param info - строка с введеной фамилией, именем, отчетсвом и датой рождения
     */
    public void parsing(String info)
    {
        String[] infoParse = info.split(" ");

        if (infoParse.length == 4)
        {
            if (infoParse[0].chars().allMatch(Character::isLetter) && infoParse[1].chars().allMatch(Character::isLetter) && infoParse[2].chars().allMatch(Character::isLetter))
            {
                System.out.print(infoParse[0] + " " + infoParse[1].charAt(0) + "." + infoParse[2].charAt(0) + ". ");

                if (infoParse[0].charAt(infoParse[0].length() - 1) == 'а') {
                    System.out.print("Ж ");
                } else {
                    System.out.print("М ");
                }

                String[] dataParse = infoParse[3].split("\\.");


                try {
                    LocalDate DateOfBirth = LocalDate.of(parseInt(dataParse[2]), parseInt(dataParse[1]), parseInt(dataParse[0]));

                    Period data = Period.between(DateOfBirth, LocalDate.now());
                    int years = data.getYears();
                    
                    if (years >= 0 && years <= LocalDate.now().getYear() && data.getMonths() >= 0 && data.getDays() >= 0)
                    {
                        System.out.print(years + " ");

                        switch (years % 100) {
                            case 1, 21, 31, 41, 51, 61, 71, 81, 91 -> System.out.print("год");
                            case 2, 22, 32, 42, 52, 62, 72, 82, 92, 3, 23, 33, 43, 53, 63, 73, 83, 93, 4, 24, 34, 44, 54, 64, 74, 84, 94 ->
                                    System.out.print("года");
                            default -> System.out.println("лет");
                        }
                    }
                    else
                    {
                        System.out.println("\nВведена некорректная дата!!!");
                    }
                }
                catch (DateTimeException ex)
                {
                    System.out.println("\nНеправильно введена дата рождения. Ошибка DateTimeException!!!");
                }
                catch (NumberFormatException ex)
                {
                    System.out.println("\nНеправильно введена дата рождения. Ошибка NumberFormatException!!!");
                }
            }
            else
            {
                System.out.println("В ФИО допущена ошибка (не все символы являются буквами)!!!");
            }
        }
        else
        {
            System.out.println("Некорректные данные (не хватает информации, либо пропущен пробел)!!!");
        }
    }
}
