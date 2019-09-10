package f_SOLID.LoggerTask.appenders.interfaces;

import f_SOLID.LoggerTask.enumerations.ReportLevel;

import java.io.IOException;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message) throws IOException;
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();
}
