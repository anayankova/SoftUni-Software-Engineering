import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeDate.setDate;

public class code7 {
    public static void main(String[] args) throws ParseException {
        String dateFormat = "dd/MM/yyyy";
        Scanner scanner = new Scanner(System.in);
        setDate(new SimpleDateFormat(dateFormat).parse(scanner.nextLine()));




    }
}
