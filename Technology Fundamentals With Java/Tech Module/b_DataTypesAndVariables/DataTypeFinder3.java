package b_DataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class DataTypeFinder3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("END")){
                break;
            }
            showPrimitive(input);//check for every input
        }
    }

    private static void showPrimitive(Object input) {
        try {
            if (input instanceof Integer)
                System.out.println("Primitive : int");
            else if (input instanceof Float)
                System.out.println("Primitive : float");
            else if (input instanceof Boolean)
                System.out.println("Primitive : boolean");
            else if (input instanceof Character)
                System.out.println("Primitive : char");
            else
                System.out.println("Reference : string");
        } catch (InputMismatchException e) {
            System.out.println("Exception occur = " + e);
        }
    }
}

