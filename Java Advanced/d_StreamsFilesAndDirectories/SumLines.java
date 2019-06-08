package d_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/res-ex/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
                long sum = 0;
                for (char symbol : line.toCharArray()) {
                    sum += symbol;
                }
                System.out.println(sum);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
