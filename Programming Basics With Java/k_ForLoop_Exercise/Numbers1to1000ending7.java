package k_ForLoop_Exercise;

public class Numbers1to1000ending7 {
    public static void main(String[] args) {

        for (int i = 7; i <= 997; i++){    //i +=10 // 7  17  27  37...
            if (i % 10 == 7) {
                System.out.println(i);
            }
        }

    }
}
