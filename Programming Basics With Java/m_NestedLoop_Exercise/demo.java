package m_NestedLoop_Exercise;

public class demo {
    public static void main(String[] args) {

        for (int i = 1; i < 100 ; i++) {
            if (i %10 == 5){
                continue;
            }
            System.out.println(i);   //при число, завършващо на 5, цикъла продължава и не минава през print

        }

    }
}
