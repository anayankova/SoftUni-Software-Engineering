package f_ObjectsAndClasses;

public class demoClassInFile {

    static class A{
        public int value1;
        public String value2;
    }
    public static void main(String[] args) {
        System.out.println(doSomething().value2);
        System.out.println(doSomething().value1);

    }

      static A doSomething(){
        A a = new A();
        a.value1 = 10;
        a.value2 ="Pesho";
        return a;

    }
}
