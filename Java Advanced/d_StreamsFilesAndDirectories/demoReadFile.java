package d_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demoReadFile {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        String path = userDir + "/res-lab/input.txt";

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
