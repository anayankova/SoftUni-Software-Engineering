package i_TextProcessingAndRegularExpressions;

public class demo1 {
    public static void main(String[] args) {
        String str = new String(new char[] {'s', 't', 'r'});
        char[] charArr = str.toCharArray();
         // ['s', 't', 'r']

        System.out.println(charArr);
        System.out.println(str);

        for (char i : charArr){
            System.out.println(i);
        }


    }
}
