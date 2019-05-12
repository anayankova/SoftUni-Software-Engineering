package c_Arrays;

public class demo9 {
    public static void main(String[] args) {
        String[] arr = {"one", "two"};
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

        System.out.println(String.join(" ",arr));
    }

}
