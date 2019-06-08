package d_StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");
        String inputPath = userDir + "/res-ex/input.txt";
        String outputPath = userDir + "/res-ex/04.output.txt";

        //FileReader fileReader = new FileReader(inputPath);
        //BufferedReader reader = new BufferedReader(fileReader);

        String text = Files.readString(Path.of(inputPath)).replaceAll("\r\n", " ");

        int[] countData = new int[3];

        String vowels = "aeiou";

        String punctuation = "!.,?";

        for (char symbol : text.toCharArray()) {
            if (vowels.contains(symbol + "")) {
                countData[0]++;
            } else if (punctuation.contains(symbol + "")) {
                countData[2]++;
            } else if (symbol != ' ') {
                countData[1]++;
            }
        }


        PrintWriter printer = new PrintWriter(outputPath);

        printer.printf("Vowels: %d%n" + "Consonants: %d%n" + "Punctuation: %d%n",
                countData[0], countData[1], countData[2]);

        printer.close();

    }
}
