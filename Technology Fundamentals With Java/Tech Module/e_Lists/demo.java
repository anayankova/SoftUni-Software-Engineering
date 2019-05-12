package e_Lists;

import java.util.ArrayList;
import java.util.List;

public class demo {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
            //Create a list of strings
        names.add("Peter");
        names.add("Maria");
        names.add("George");
        names.add(1,"Peter");
        names.remove("Maria");
        names.remove(2);
        for (String name : names)
            System.out.println(name);
                 //Peter, George


    }
}
