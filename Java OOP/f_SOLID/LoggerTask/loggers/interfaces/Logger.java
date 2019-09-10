package f_SOLID.LoggerTask.loggers.interfaces;

import java.io.IOException;

public interface Logger {
    void logInfo(String data, String message) throws IOException;
    void logWarning(String data, String message) throws IOException;
    void logError(String data, String message) throws IOException;
    void logCritical(String data, String message) throws IOException;
    void logFatal(String data, String message) throws IOException;

}
