import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class a1000daysOnEarth {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(scanner.nextLine(), format);
        LocalDate result = localDate.plusDays(1000);

        System.out.println(format.format(result));


    }
}
