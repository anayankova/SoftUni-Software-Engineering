package b_DataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class DataTypeFinder2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; ++i) {
            String input = br.readLine();
            showPrimitive(input);//check for every input
        }
    }

    private static void showPrimitive(Object input) {
        try {
            if (input instanceof Short)
                System.out.println("Primitive : short");
            else if (input instanceof Integer)
                System.out.println("Primitive : int");
            else if (input instanceof Long)
                System.out.println("Primitive : long");
            else if (input instanceof Float)
                System.out.println("Primitive : float");
            else if (input instanceof Double)
                System.out.println("Primitive : double");
            else if (input instanceof Boolean)
                System.out.println("Primitive : bool");
            else if (input instanceof Character)
                System.out.println("Primitive : char");
            else if (input instanceof Byte)
                System.out.println("Primitive : byte");
            else
                System.out.println("Reference : string");
        } catch (InputMismatchException e) {
            System.out.println("Exception occur = " + e);
        }
    }
}

