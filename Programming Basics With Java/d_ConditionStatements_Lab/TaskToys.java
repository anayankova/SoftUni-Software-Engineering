package d_ConditionStatements_Lab;

import java.util.Scanner;

public class TaskToys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceEvent = Double.parseDouble(scanner.nextLine());
        int piecesPuzzle = Integer.parseInt(scanner.nextLine());
        int piecesToys1 = Integer.parseInt(scanner.nextLine());
        int piecesBears = Integer.parseInt(scanner.nextLine());
        int piecesMinion = Integer.parseInt(scanner.nextLine());
        int piecesAutos = Integer.parseInt(scanner.nextLine());

        double winMoney = piecesPuzzle*2.6 + piecesToys1*4 + piecesBears*4.1 + piecesMinion*8.2 + piecesAutos*2;
        double finalwinMoney = winMoney - 0.1*winMoney;
        double allpieces = piecesPuzzle+piecesAutos+piecesBears+piecesMinion+piecesToys1;

        if(allpieces>=50){
            finalwinMoney = finalwinMoney - 0.25*finalwinMoney;
        }

        if (finalwinMoney>=priceEvent){
            System.out.print("Yes!");
            System.out.print(finalwinMoney-priceEvent);
            System.out.print(" lv left.");
        }else{
            System.out.print("Not enough money!");
            System.out.print(priceEvent-finalwinMoney);
            System.out.print("lv needed.");
        }

    }
}
