package f_NestedConditionalStatements_Lab;

public class demo6 {
    public static void main(String[] args) {
        int number = 101;
        if (number >= 1) {
            System.out.println("Larger than 1");
            if (number <= 101) {
                System.out.println("Less than 101");

            }else {
                System.out.println("Equal to 101");
            }
        }
    }
}