package f_SOLID.LoggerTask.customFiles.interfaces;

public interface File {
    void write();
    int getSize();
    void appendBuffer(String text);
}
