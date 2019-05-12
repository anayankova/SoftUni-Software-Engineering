package o_ExamSample;

import java.util.Scanner;

public class SpaseShip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double averageHeight = Double.parseDouble(scanner.nextLine());

        double volume = width * length * height;
        double volumeRoom = (averageHeight + 0.40) * 2 * 2;
        double count = Math.floor(volume / volumeRoom);

        if (count > 3 && count < 10) {
            System.out.printf("The spacecraft holds %.0f astronauts.", count);
        } else if (count < 3) {
            System.out.println("The spacecraft is too small.");
        } else if (count > 10) {
            System.out.println("The spacecraft is too big.");
        }

    }
}
