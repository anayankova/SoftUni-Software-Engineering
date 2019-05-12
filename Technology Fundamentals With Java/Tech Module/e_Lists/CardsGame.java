package e_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> cardsFirstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> cardsSecondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sumFirstPlayer = 0;
        int sumSecondPlayer = 0;
        String win = "";

        for (int i = 0; i < cardsFirstPlayer.size(); i++) {

            if (cardsFirstPlayer.get(i) > cardsSecondPlayer.get(i)) {
                sumFirstPlayer += cardsFirstPlayer.get(i)+cardsSecondPlayer.get(i);
                cardsFirstPlayer.remove(i);
                cardsSecondPlayer.remove(i);
                i = -1;
                win = "first";
            }else if (cardsFirstPlayer.get(i) < cardsSecondPlayer.get(i)){
                sumSecondPlayer += cardsFirstPlayer.get(i)+cardsSecondPlayer.get(i);
                cardsFirstPlayer.remove(i);
                cardsSecondPlayer.remove(i);
                i = -1;
                win = "second";
            }else if (cardsFirstPlayer.get(i) == cardsSecondPlayer.get(i)){
                if (win.equals("")){
                    cardsFirstPlayer.remove(i);
                    cardsSecondPlayer.remove(i);
                }else if (win.equals("first")){
                    sumFirstPlayer += cardsFirstPlayer.get(i)+cardsSecondPlayer.get(i);
                    cardsFirstPlayer.remove(i);
                    cardsSecondPlayer.remove(i);
                }else {
                    sumSecondPlayer += cardsFirstPlayer.get(i)+cardsSecondPlayer.get(i);
                    cardsFirstPlayer.remove(i);
                    cardsSecondPlayer.remove(i);
                }
                i = -1;

            }
        }

        if (sumFirstPlayer > sumSecondPlayer){
            System.out.printf("First player wins! Sum: %d",sumFirstPlayer - sumSecondPlayer);
        }else {
            System.out.printf("Second player wins! Sum: %d",sumSecondPlayer - sumFirstPlayer);
        }

    }
}
