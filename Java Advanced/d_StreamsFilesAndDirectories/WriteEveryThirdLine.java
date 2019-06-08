package d_StreamsFilesAndDirectories;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res-lab/input.txt";
        String outputPath = userDir + "/res-lab/05.WriteEveryThirdLineOutput.txt";

        try (BufferedReader in =
                     new BufferedReader(new FileReader(inputPath));
             PrintWriter out =
                     new PrintWriter(new FileWriter(outputPath))) {
            int counter = 1;
            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
