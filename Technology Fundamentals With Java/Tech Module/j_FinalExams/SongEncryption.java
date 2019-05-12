package j_FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^[A-Z][a-z\\'\\s]+\\:[A-Z\\s]+$");

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("end")) {
            Matcher inputLineMatcher = pattern.matcher(inputLine);

            if (inputLineMatcher.find()) {
                String artistName = inputLine.split("\\:")[0];
                int encryptionKey = artistName.length();

                String encryptedString = "";

                for (int i = 0; i < inputLine.length(); i++) {
                    char currentChar = inputLine.charAt(i);

                    if (currentChar != '\'' && currentChar != ' ' && currentChar != ':') {
                        int currentCharASCI = (int) currentChar;

                        if (currentCharASCI >= 65 && currentCharASCI <= 90) {
                            currentCharASCI += encryptionKey;

                            if (currentCharASCI > 90) {
                                currentCharASCI = (currentCharASCI % 90) + 64;
                            }
                        }else {
                            currentCharASCI += encryptionKey;

                            if(currentCharASCI > 122){
                                currentCharASCI = (currentCharASCI % 122) + 96;
                            }
                        }

                        currentChar = (char) currentCharASCI;

                    }
                    encryptedString += currentChar;
                }

                System.out.println("Successful encryption: "
                        + encryptedString.replace(":", "@"));

            } else {
                System.out.println("Invalid input!");
            }

            inputLine = scanner.nextLine();
        }

    }
}
