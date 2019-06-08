package d_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class demoClosingFile {
    public static void main(String[] args) {
        String path = "C:\\input.txt";

        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                System.out.print(oneByte);
                oneByte = in.read();
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }


    }
}
