package l_NestedLoop_Lab;

public class demo6 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 2 || i == 3) {
                continue;
            }
            System.out.print(i + " ");
        }


    }
}
