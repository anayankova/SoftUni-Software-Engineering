package d_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/res-ex/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            long sum = 0;
            String line = reader.readLine();
            while (line != null) {
                for (char symbol : line.toCharArray()) {
                    sum += symbol;
                }
                line = reader.readLine();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
