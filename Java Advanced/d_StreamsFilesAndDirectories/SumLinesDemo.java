package d_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumLinesDemo {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try{
            String line = reader.readLine();
            while (!line.equals("")){
                int asciiSum = 0;
                for(char symbol : line.toCharArray()){
                    asciiSum += symbol;
                }
                System.out.println(asciiSum);
                line = reader.readLine();
            }

        }catch (IOException ex){

        }

    }
}
