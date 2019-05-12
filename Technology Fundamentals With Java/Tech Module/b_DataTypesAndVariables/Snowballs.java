package b_DataTypesAndVariables;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long snowballValueMax = 0;
        int snowballSnowOutput = 0;
        int snowballTimeOutput = 0;
        int snowballQualityOutput = 0;

        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            long snowballValue = (long) Math.pow((snowballSnow * 1.0 / snowballTime), snowballQuality);

            if (snowballValue > snowballValueMax) {
                snowballValueMax = snowballValue;
                snowballSnowOutput = snowballSnow;
                snowballTimeOutput = snowballTime;
                snowballQualityOutput = snowballQuality;

            }
        }

        System.out.printf("%d : %d = %d (%d)",snowballSnowOutput,snowballTimeOutput,
                snowballValueMax,snowballQualityOutput);

    }
}
