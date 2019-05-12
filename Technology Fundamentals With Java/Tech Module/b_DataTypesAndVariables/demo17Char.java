package b_DataTypesAndVariables;

public class demo17Char {
    public static void main(String[] args) {
        char a = '1';
        System.out.println(a);
        System.out.println(+a);
        System.out.println((int)a);
        System.out.printf("%c",+a);
        System.out.println();
        System.out.printf("%d",+a);
        System.out.println();
        int n = a;
        System.out.println(n);
        char b = 'b';
        System.out.printf("%c%c%n",a,b);
        System.out.printf("%d%d%n",(int)a,(int)b);
        int c = a + b;
        String d = String.format("%c",a+b);
        System.out.println(c);
        System.out.println(d);

    }
}
