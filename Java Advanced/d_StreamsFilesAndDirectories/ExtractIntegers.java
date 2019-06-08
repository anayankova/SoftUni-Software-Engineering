package d_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res-lab/input.txt";
        String outputPath = userDir + "/res-lab/04.ExtractIntegersOutput.txt";
        try (Scanner scanner =
                     new Scanner(new FileInputStream(inputPath));
             PrintWriter out =
                     new PrintWriter(new FileOutputStream(outputPath))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    out.println(scanner.nextInt());
                }
                scanner.next();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
