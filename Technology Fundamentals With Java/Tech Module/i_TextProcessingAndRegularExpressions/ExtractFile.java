package i_TextProcessingAndRegularExpressions;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String name = input.substring(input.lastIndexOf("\\") + 1, input.lastIndexOf("."));
        String extension = input.substring(input.lastIndexOf(".") + 1);

        System.out.println(String.format("File name: %s", name));
        System.out.println(String.format("File extension: %s", extension));

    }
}
