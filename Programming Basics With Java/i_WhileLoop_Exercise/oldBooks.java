package i_WhileLoop_Exercise;

import java.util.Scanner;

public class oldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searchedBook = scanner.nextLine();
        int booksinLibrary = Integer.parseInt(scanner.nextLine());

        String book = scanner.nextLine();
        int checkBooks =0;

        while (!searchedBook.equals(book) || booksinLibrary != checkBooks) {
            if (book.equals(searchedBook)) {
                System.out.printf("You checked %d books and found it.", checkBooks);
                break;
            } else {
                checkBooks++;
            }
            if (booksinLibrary == checkBooks) {
                System.out.printf("The book you search is not here!%nYou checked %d books.",checkBooks);
                break;
            }
            book = scanner.nextLine();
        }


    }
}

