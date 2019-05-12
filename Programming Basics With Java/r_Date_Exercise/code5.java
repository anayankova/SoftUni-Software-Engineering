import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class code5 {

    public static void main(String[] args) {
        Date now = new Date();

        // Use Date.toString()
        System.out.println(now);

        // Use DateFormat
        DateFormat formatter = DateFormat.getInstance(); // Date and time
        String dateStr = formatter.format(now);
        System.out.println(dateStr);
        formatter = DateFormat.getTimeInstance();        // time only
        System.out.println(formatter.format(now));

        // Use locale
        formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.FRANCE);
        System.out.println(formatter.format(now));

        // Use SimpleDateFormat
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println(simpleFormatter.format(now));
    }
}