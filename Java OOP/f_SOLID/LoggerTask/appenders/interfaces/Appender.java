package f_SOLID.LoggerTask.appenders.interfaces;

import f_SOLID.LoggerTask.enumerations.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
}
