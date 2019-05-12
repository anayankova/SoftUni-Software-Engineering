package m_NestedLoop_Exercise;

import java.util.Scanner;

public class EqualSumsLeftRightPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        for (int i = num1; i <= num2; i++) {
            String n = i + "";
            int rightSum = 0;
            int leftSum = 0;
            int smallerSum = 0;
            int newSum = 0;
            while (true) {
                int n1 = Integer.parseInt(n.charAt(0) + "");
                int n2 = Integer.parseInt(n.charAt(1) + "");
                int n3 = Integer.parseInt(n.charAt(2) + "");
                int n4 = Integer.parseInt(n.charAt(3) + "");
                int n5 = Integer.parseInt(n.charAt(4) + "");
                rightSum = n1 + n2;
                leftSum = n4 + n5;
                if (rightSum == leftSum) {
                    System.out.print(i + " ");
                    break;
                } else {
                    if (rightSum > leftSum) {
                        smallerSum = leftSum;
                        newSum = smallerSum + n3;
                        if (rightSum == newSum) {
                            System.out.print(i + " ");
                            break;
                        }else {
                            break;
                        }
                    } else {
                        smallerSum = rightSum;
                        newSum = smallerSum + n3;
                        if (leftSum == newSum) {
                            System.out.print(i + " ");
                            break;
                        }else{
                            break;
                        }
                    }

                }

            }


        }


    }
}
