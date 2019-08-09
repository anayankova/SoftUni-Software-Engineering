package f_SOLID.LoggerTask;

import f_SOLID.LoggerTask.appenders.ConsoleAppender;
import f_SOLID.LoggerTask.appenders.interfaces.Appender;
import f_SOLID.LoggerTask.enumerations.ReportLevel;
import f_SOLID.LoggerTask.layouts.SimpleLayout;
import f_SOLID.LoggerTask.layouts.interfaces.Layout;

public class Main {
    public static void main(String[] args) {

        Layout layout = new SimpleLayout();

        System.out.println(layout.format("3/26/2015 2:08:11 PM",
                ReportLevel.ERROR, "Error parsing JSON."));

        Appender consoleAppender = new ConsoleAppender(layout);

        consoleAppender.append("Date", ReportLevel.INFO, "Message");

    }
}
