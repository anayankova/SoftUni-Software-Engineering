package e_ConditionStatements_Exercise;

import java.util.Scanner;

public class NumbersFrom0to100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

        if (a % 10 == a){
            if(a == 0){
                System.out.println("null");
            }else if (a == 1){
                System.out.println("one");
            }else if (a == 2){
                System.out.println("two");
            }else if (a == 3){
                System.out.println("three");
            }else if (a == 4){
                System.out.println("four");
            }else if (a == 5){
                System.out.println("five");
            }else if (a == 6){
                System.out.println("six");
            }else if (a == 7){
                System.out.println("seven");
            }else if (a == 8){
                System.out.println("eight");
            }else if (a == 9){
                System.out.println("nine");
            }
        }

        if (a % 10 != a && a % 100 == a){
            int decimal = a/10;
            int unit = a%10;
            if(decimal == 1){
                String teen = "teen";
                if (unit == 0) {
                System.out.println("ten");
                }else if (unit == 1){
                    System.out.println("eleven");
                }else if (unit == 2){
                    System.out.println("twelve");
                }else if (unit == 3){
                    System.out.printf("thir%s",teen);
                }else if (unit == 4){
                    System.out.printf("four%s",teen);
                }else if (unit == 5){
                    System.out.printf("fif%s",teen);
                }else if (unit == 6){
                    System.out.printf("six%s",teen);
                }else if (unit == 7){
                    System.out.printf("seven%s",teen);
                }else if (unit == 8){
                    System.out.printf("eigh%s",teen);
                }else if (unit == 9){
                    System.out.printf("nine%s",teen);
                }
            }

            if (decimal == 2){
                String twenty = "twenty";
                if (unit == 0){
                    System.out.println(twenty);
                }else if (unit == 1){
                    System.out.printf("%s one",twenty);
                }else if (unit == 2){
                    System.out.printf("%s two",twenty);
                }else if (unit == 3){
                    System.out.printf("%s three",twenty);
                }else if (unit == 4){
                    System.out.printf("%s four",twenty);
                }else if (unit == 5){
                    System.out.printf("%s five",twenty);
                }else if (unit == 6){
                    System.out.printf("%s six",twenty);
                }else if (unit == 7){
                    System.out.printf("%s seven",twenty);
                }else if (unit == 8){
                    System.out.printf("%s eight",twenty);
                }else if (unit == 9){
                    System.out.printf("%s nine",twenty);
                }
            }

            if (decimal == 3){
                String thirty = "thirty";
                if (unit == 0){
                    System.out.println(thirty);
                }else if (unit == 1){
                    System.out.printf("%s one",thirty);
                }else if (unit == 2){
                    System.out.printf("%s two",thirty);
                }else if (unit == 3){
                    System.out.printf("%s three",thirty);
                }else if (unit == 4){
                    System.out.printf("%s four",thirty);
                }else if (unit == 5){
                    System.out.printf("%s five",thirty);
                }else if (unit == 6){
                    System.out.printf("%s six",thirty);
                }else if (unit == 7){
                    System.out.printf("%s seven",thirty);
                }else if (unit == 8){
                    System.out.printf("%s eight",thirty);
                }else if (unit == 9){
                    System.out.printf("%s nine",thirty);
                }
            }

            if (decimal == 4){
                String forty = "forty";
                if (unit == 0){
                    System.out.println(forty);
                }else if (unit == 1){
                    System.out.printf("%s one",forty);
                }else if (unit == 2){
                    System.out.printf("%s two",forty);
                }else if (unit == 3){
                    System.out.printf("%s three",forty);
                }else if (unit == 4){
                    System.out.printf("%s four",forty);
                }else if (unit == 5){
                    System.out.printf("%s five",forty);
                }else if (unit == 6){
                    System.out.printf("%s six",forty);
                }else if (unit == 7){
                    System.out.printf("%s seven",forty);
                }else if (unit == 8){
                    System.out.printf("%s eight",forty);
                }else if (unit == 9){
                    System.out.printf("%s nine",forty);
                }
            }

            if (decimal == 5){
                String fifty = "fifty";
                if (unit == 0){
                    System.out.println(fifty);
                }else if (unit == 1){
                    System.out.printf("%s one",fifty);
                }else if (unit == 2){
                    System.out.printf("%s two",fifty);
                }else if (unit == 3){
                    System.out.printf("%s three",fifty);
                }else if (unit == 4){
                    System.out.printf("%s four",fifty);
                }else if (unit == 5){
                    System.out.printf("%s five",fifty);
                }else if (unit == 6){
                    System.out.printf("%s six",fifty);
                }else if (unit == 7){
                    System.out.printf("%s seven",fifty);
                }else if (unit == 8){
                    System.out.printf("%s eight",fifty);
                }else if (unit == 9){
                    System.out.printf("%s nine",fifty);
                }
            }

            if (decimal == 6){
                String sixty = "sixty";
                if (unit == 0){
                    System.out.println(sixty);
                }else if (unit == 1){
                    System.out.printf("%s one",sixty);
                }else if (unit == 2){
                    System.out.printf("%s two",sixty);
                }else if (unit == 3){
                    System.out.printf("%s three",sixty);
                }else if (unit == 4){
                    System.out.printf("%s four",sixty);
                }else if (unit == 5){
                    System.out.printf("%s five",sixty);
                }else if (unit == 6){
                    System.out.printf("%s six",sixty);
                }else if (unit == 7){
                    System.out.printf("%s seven",sixty);
                }else if (unit == 8){
                    System.out.printf("%s eight",sixty);
                }else if (unit == 9){
                    System.out.printf("%s nine",sixty);
                }
            }

            if (decimal == 7){
                String seventy = "seventy";
                if (unit == 0){
                    System.out.println(seventy);
                }else if (unit == 1){
                    System.out.printf("%s one",seventy);
                }else if (unit == 2){
                    System.out.printf("%s two",seventy);
                }else if (unit == 3){
                    System.out.printf("%s three",seventy);
                }else if (unit == 4){
                    System.out.printf("%s four",seventy);
                }else if (unit == 5){
                    System.out.printf("%s five",seventy);
                }else if (unit == 6){
                    System.out.printf("%s six",seventy);
                }else if (unit == 7){
                    System.out.printf("%s seven",seventy);
                }else if (unit == 8){
                    System.out.printf("%s eight",seventy);
                }else if (unit == 9){
                    System.out.printf("%s nine",seventy);
                }
            }

            if (decimal == 8){
                String eighty = "eighty";
                if (unit == 0){
                    System.out.println(eighty);
                }else if (unit == 1){
                    System.out.printf("%s one",eighty);
                }else if (unit == 2){
                    System.out.printf("%s two",eighty);
                }else if (unit == 3){
                    System.out.printf("%s three",eighty);
                }else if (unit == 4){
                    System.out.printf("%s four",eighty);
                }else if (unit == 5){
                    System.out.printf("%s five",eighty);
                }else if (unit == 6){
                    System.out.printf("%s six",eighty);
                }else if (unit == 7){
                    System.out.printf("%s seven",eighty);
                }else if (unit == 8){
                    System.out.printf("%s eight",eighty);
                }else if (unit == 9){
                    System.out.printf("%s nine",eighty);
                }
            }

            if (decimal == 9){
                String ninety = "ninety";
                if (unit == 0){
                    System.out.println(ninety);
                }else if (unit == 1){
                    System.out.printf("%s one",ninety);
                }else if (unit == 2){
                    System.out.printf("%s two",ninety);
                }else if (unit == 3){
                    System.out.printf("%s three",ninety);
                }else if (unit == 4){
                    System.out.printf("%s four",ninety);
                }else if (unit == 5){
                    System.out.printf("%s five",ninety);
                }else if (unit == 6){
                    System.out.printf("%s six",ninety);
                }else if (unit == 7){
                    System.out.printf("%s seven",ninety);
                }else if (unit == 8){
                    System.out.printf("%s eight",ninety);
                }else if (unit == 9){
                    System.out.printf("%s nine",ninety);
                }
            }
        }

        if (a % 10 != a && a % 100 != a && a % 1000 == a){
            if (a == 100){
                System.out.println("hundred");
            }else{
                System.out.println("bigger than hundred");
            }
        }

    }
}
