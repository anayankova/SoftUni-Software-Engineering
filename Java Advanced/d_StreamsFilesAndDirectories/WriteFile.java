package d_StreamsFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res-lab/input.txt";
        String outputPath = userDir + "/res-lab/02.WriteToFileOutput.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char)oneByte)) {
                    out.write(oneByte);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }



    }
}
