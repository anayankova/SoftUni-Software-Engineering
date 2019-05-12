package g_MidExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CookingFactory2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine().toLowerCase();
        int bestGeneralQuality = Integer.MIN_VALUE;
        int currentGeneralQuality;
        int bestLength = 10;
        int currentLength = 0;
        int[] bestBatch = new int[10];

        while (!command.equals("bake it!")) {
            int[] quality = Arrays
                    .stream(command.split("#"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            currentGeneralQuality = Arrays.stream(quality).sum();
            if (currentGeneralQuality > bestGeneralQuality) {
                bestGeneralQuality = currentGeneralQuality;
                bestBatch = quality;
                bestLength = quality.length;
            } else if (currentGeneralQuality == bestGeneralQuality) {
                currentLength = quality.length;
                if (currentLength < bestLength) {
                    bestLength = currentLength;
                    bestBatch = quality;
                }
            }
            command = reader.readLine().toLowerCase();

        }
        System.out.printf("Best Batch quality: %d%n", bestGeneralQuality);
        for (int bread : bestBatch) {
            System.out.print(bread + " ");
        }
    }
}
