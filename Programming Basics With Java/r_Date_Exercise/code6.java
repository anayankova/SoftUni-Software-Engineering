import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class code6 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner("Monday 12 December 2013,a, other fields");
        scanner.useDelimiter(",");

        String dateString = scanner.next();
        //System.out.println(dateString);

        DateFormat formatter = new SimpleDateFormat("EEEE dd MMM yyyy");
        Date date = formatter.parse(dateString);
        //System.out.println(date);


    }
}
