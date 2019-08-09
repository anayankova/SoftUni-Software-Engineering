package f_SOLID.LoggerTask.layouts;

import f_SOLID.LoggerTask.enumerations.ReportLevel;
import f_SOLID.LoggerTask.layouts.interfaces.Layout;

public class SimpleLayout implements Layout {
    public SimpleLayout() {
        //TODO: Check if constructor needed
    }

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel.toString(), message);
    }
}
