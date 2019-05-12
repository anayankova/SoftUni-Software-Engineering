package h_WhileLoop_Lab;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int volume = width * length * height;

        while (true){
            String input = scanner.nextLine();
            if (input.equals("Done")){
                System.out.println(volume + " Cubic meters left.");
                break;
            }
            int boxVolume = Integer.parseInt(input);
            volume = volume - boxVolume;
            if (volume < 0){
                System.out.printf("No more free space! You need %d Cubic meters more.",Math.abs(volume));
                break;
            }
        }

    }
}
