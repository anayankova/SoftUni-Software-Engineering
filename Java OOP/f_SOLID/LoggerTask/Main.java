package f_SOLID.LoggerTask;

import f_SOLID.LoggerTask.appenders.ConsoleAppender;
import f_SOLID.LoggerTask.appenders.FileAppender;
import f_SOLID.LoggerTask.appenders.SocketAppender;
import f_SOLID.LoggerTask.appenders.interfaces.Appender;
import f_SOLID.LoggerTask.customFiles.LogFile;
import f_SOLID.LoggerTask.customFiles.interfaces.File;
import f_SOLID.LoggerTask.enumerations.ReportLevel;
import f_SOLID.LoggerTask.layouts.SimpleLayout;
import f_SOLID.LoggerTask.layouts.XmlLayout;
import f_SOLID.LoggerTask.layouts.interfaces.Layout;
import f_SOLID.LoggerTask.loggers.MessageLogger;
import f_SOLID.LoggerTask.loggers.interfaces.Logger;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //TODO: 1
        //Layout layout = new SimpleLayout();

        //System.out.println(layout.format("3/26/2015 2:08:11 PM",
        //        ReportLevel.ERROR, "Error parsing JSON."));

        //Appender consoleAppender = new ConsoleAppender(layout);

        //consoleAppender.append("Date", ReportLevel.INFO, "Message");

        //TODO: 2
        //Layout simpleLayout = new SimpleLayout();
        //Appender consoleAppender = new ConsoleAppender(simpleLayout);
        //Logger logger = new MessageLogger(consoleAppender);
//
        //logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        //logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

        //TODO: 3
        //Layout simpleLayout = new SimpleLayout();
        //Appender consoleAppender = new ConsoleAppender(simpleLayout);

        //File file = new LogFile();
        //Appender fileAppender = new FileAppender(simpleLayout);
        //((FileAppender) fileAppender).setFile(file);

        //Logger logger = new MessageLogger(consoleAppender, fileAppender);

        //logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
        //logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");

        //System.out.println(file.getSize());

        //TODO: 4
        //Scanner scanner = new Scanner(System.in);

        //int n = Integer.parseInt(scanner.nextLine());

        //Appender[] appenders = new Appender[n];

        //int index = 0;

        //while (n-- > 0){
        //    String[] tokens = scanner.nextLine().split("\\s+");
        //    Appender appender = null;
        //    Layout layout = null;

        //    if(tokens[1].equals("SimpleLayout")){
        //        layout = new SimpleLayout();
        //    }else {
        //        layout = new XmlLayout();
        //    }

        //    if(tokens[0].equals("ConsoleAppender")){
        //        appender = new ConsoleAppender(layout);
        //    }else {
        //        appender = new FileAppender(layout);
        //    }

        //    if(tokens.length == 3){
        //        appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        //    }

        //    appenders[index++] = appender;

        //}

        //Logger logger = new MessageLogger(appenders);

        //String line = scanner.nextLine();

        //while (!line.equals("END")){

        //    String[] tokens = line.split("\\|");

        //    switch (ReportLevel.valueOf(tokens[0])){
        //        case INFO:
        //            logger.logInfo(tokens[1], tokens[2]);
        //            break;
        //        case ERROR:
        //            logger.logError(tokens[1], tokens[2]);
        //            break;
        //        case FATAL:
        //            logger.logFatal(tokens[1], tokens[2]);
        //            break;
        //        case WARNING:
        //            logger.logWarning(tokens[1], tokens[2]);
        //            break;
        //        case CRITICAL:
        //            logger.logCritical(tokens[1], tokens[2]);
        //            break;
        //    }


        //    line = scanner.nextLine();
        //}

        //System.out.println(logger.toString());

        Scanner scanner = new Scanner(System.in);

        Layout layout = new XmlLayout();
        Appender appender = new SocketAppender(layout);
        Logger logger = new MessageLogger(appender);

        logger.logInfo("9/10/2019", "Hello from Socket");

    }
}
