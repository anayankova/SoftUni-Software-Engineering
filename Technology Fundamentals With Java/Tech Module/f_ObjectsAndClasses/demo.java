package f_ObjectsAndClasses;

import java.time.LocalDate;

public class demo {
    public static void main(String[] args) {

        LocalDate birthday =
                LocalDate.of(2018, 5, 5);
        System.out.println(birthday);

        LocalDate date1 = LocalDate.of(2018, 5, 5);
        LocalDate date2 = LocalDate.of(2016, 3, 5);
        LocalDate date3 = LocalDate.of(2013, 3, 2);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);



    }
}
