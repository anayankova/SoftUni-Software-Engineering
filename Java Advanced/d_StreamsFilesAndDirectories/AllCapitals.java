package d_StreamsFilesAndDirectories;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res-ex/input.txt";
        String outputPath = userDir + "/res-ex/03.output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            String line = reader.readLine();
            while (line != null) {
                writer.write(line.toUpperCase());
                writer.write(System.lineSeparator());
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
