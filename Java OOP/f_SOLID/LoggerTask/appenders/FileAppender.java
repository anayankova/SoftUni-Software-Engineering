package f_SOLID.LoggerTask.appenders;

import f_SOLID.LoggerTask.customFiles.LogFile;
import f_SOLID.LoggerTask.customFiles.interfaces.File;
import f_SOLID.LoggerTask.enumerations.ReportLevel;
import f_SOLID.LoggerTask.layouts.interfaces.Layout;

import java.io.IOException;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public void setFile(File file){
        this.file = file;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if(this.file == null){
            //throw new NullPointerException("File reference is not set");
            try {
                this.setFile(new LogFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = this.format(date, reportLevel, message);
        this.file.appendBuffer(str);
        this.file.write();
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
