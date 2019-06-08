package d_StreamsFilesAndDirectories;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res-lab/input.txt";
        String outputPath = userDir + "/res-lab/03.CopyBytesOutput.txt";

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                }else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
