package f_SOLID.LoggerTask.layouts.interfaces;

import f_SOLID.LoggerTask.enumerations.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
}
