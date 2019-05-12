package i_TextProcessingAndRegularExpressions.StringBuilder;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("aaa");
        SomeClass someClass = new SomeClass(sb);
        System.out.println(someClass.getContent());
        doSomething(someClass);
        System.out.println(someClass.getContent());

    }

    private static void doSomething(SomeClass sb) {
        sb.getSb().setLength(0);
    }
}
