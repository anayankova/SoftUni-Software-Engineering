package f_SOLID.LoggerTask.loggers;

import f_SOLID.LoggerTask.appenders.interfaces.Appender;
import f_SOLID.LoggerTask.enumerations.ReportLevel;
import f_SOLID.LoggerTask.loggers.interfaces.Logger;

import java.io.IOException;

public class MessageLogger implements Logger {

    private Appender[] appenders;

    public MessageLogger(Appender... args) {
        this.appenders = args;
    }

    @Override
    public void logInfo(String data, String message) throws IOException {
        this.logMessage(data, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String data, String message) throws IOException {
        this.logMessage(data, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String data, String message) throws IOException {
        this.logMessage(data, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String data, String message) throws IOException {
        this.logMessage(data, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String data, String message) throws IOException {
        this.logMessage(data, ReportLevel.FATAL, message);
    }

    private void logMessage(String data, ReportLevel reportLevel, String message) throws IOException {
        for (Appender appender : this.appenders) {
            if(appender.getReportLevel().compareTo(reportLevel) <= 0)
            appender.append(data, reportLevel, message);
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("Logger info\r\n");

        for(Appender appender : appenders){
            builder.append(appender.toString());
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
