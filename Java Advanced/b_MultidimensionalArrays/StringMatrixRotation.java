package b_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>>matrix = new ArrayList<>();
        String command = scanner.nextLine();

        String line = "";
        int maxLength = 0;
        while(!"END".equals(line = scanner.nextLine())){
            if(line.length()>maxLength){
                maxLength = line.length();
            }
            List<String> row = new ArrayList<>();

            row = Arrays.stream(line.split("")).collect(Collectors.toList());
            matrix.add(row);
        }

        for (int r = 0; r <matrix.size() ; r++) {
            if(matrix.get(r).size()<maxLength){
                for (int i = matrix.get(r).size(); i <maxLength ; i++) {
                    matrix.get(r).add(" ");
                }
            }
        }

        String number = "";

        for (int i = 0; i <command.length() ; i++) {
            if(Character.isDigit(command.charAt(i))){
                number += command.charAt(i);
            }
        }


        int degrees = Integer.parseInt(number);

        if(degrees == 0 || degrees %360 ==0){
            printMatrix(matrix);
        }else if (degrees == 90 || degrees % 360 == 90){
            matrix =  rotateMatrix90(matrix,maxLength);
            printMatrix(matrix);
        }else if(degrees == 180 || degrees % 360 == 180){
            matrix = rotateMatrix180(matrix,maxLength);
            printMatrix(matrix);

        }else if ( degrees == 270 || degrees %360 == 270){
            matrix = rotateMatrix270(matrix,maxLength);
            printMatrix(matrix);
        }

        System.out.println();
    }

    private static List<List<String>> rotateMatrix180(List<List<String>> matrix, int maxLength) {
        List<List<String>> rotated = new ArrayList<>();
        int x = matrix.size()-1;
        int y = maxLength-1;
        for (int row = 0; row < matrix.size(); row++) {
            List<String> currentRow = new ArrayList<>();
            y = maxLength-1;
            for (int col =0; col<maxLength ; col++) {
                if(y == -1){
                    break;
                }
                currentRow.add(matrix.get(x).get(y));
                y--;
            }

            x--;
            rotated.add(currentRow);
        }
        return rotated;
    }

    private static List<List<String>> rotateMatrix270(List<List<String>> matrix, int maxLength) {
        List<List<String>> rotated = new ArrayList<>();
        int x = maxLength-1;
        int y = 0;
        for (int row = 0; row < maxLength; row++) {
            List<String> currentRow = new ArrayList<>();
            y = 0;
            for (int col = matrix.size()-1; col>=0 ; col--) {
                if(y == -1){
                    break;
                }
                currentRow.add(matrix.get(y).get(x));
                y++;
            }

            x--;
            rotated.add(currentRow);
        }
        return rotated;
    }

    private static void printMatrix(List<List<String>> matrix) {
        for (int r = 0; r <matrix.size(); r++) {
            System.out.println(matrix.get(r).stream().toString().join("",matrix.get(r)));
        }
    }

    private static List<List<String>> rotateMatrix90(List<List<String>> matrix, int maxLength) {

        List<List<String>> rotated = new ArrayList<>();
        int x = 0;
        int y = matrix.size()-1;
        for (int row = 0; row < maxLength; row++) {
            List<String> currentRow = new ArrayList<>();
            y = matrix.size()-1;
            for (int col = 0; col< matrix.size() ; col++) {
                if(y == -1){
                    break;
                }
                currentRow.add(matrix.get(y).get(x));
                y--;
            }

            x++;
            rotated.add(currentRow);
        }
        return rotated;
    }


}
