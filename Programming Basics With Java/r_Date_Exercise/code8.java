import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class code8 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Date date = sdf.parse(str);
        sdf = new SimpleDateFormat("EEE, d MMM yyyy");
        System.out.println("Date: " + sdf.format(date));

    }
}
