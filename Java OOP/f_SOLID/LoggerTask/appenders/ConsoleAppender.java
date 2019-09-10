package f_SOLID.LoggerTask.appenders;

import f_SOLID.LoggerTask.appenders.interfaces.Appender;
import f_SOLID.LoggerTask.enumerations.ReportLevel;
import f_SOLID.LoggerTask.layouts.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(this.format(date, reportLevel, message));
    }


}
