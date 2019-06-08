package d_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class demoClosingFileStream {
    public static void main(String[] args)  {
        String path = "C:\\input.txt";
        InputStream in = null;
        try {
            in = new FileInputStream(path);
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
