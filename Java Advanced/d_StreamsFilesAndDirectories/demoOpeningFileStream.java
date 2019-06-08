package d_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demoOpeningFileStream {
    public static void main(String[] args) throws IOException {
        String path = "C:\\input.txt";

        FileInputStream fileStream =
                new FileInputStream(path);

        int oneByte = fileStream.read();
        while (oneByte >= 0) {
            System.out.print(oneByte);
            oneByte = fileStream.read();
        }

        System.out.println(path);


    }
}
