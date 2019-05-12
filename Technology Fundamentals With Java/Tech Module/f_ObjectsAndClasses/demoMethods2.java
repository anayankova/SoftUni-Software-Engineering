package f_ObjectsAndClasses;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.Scanner;

public class demoMethods2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //Main.doSomething2();
        Main main = new Main();
        // main.doSomething();

    }

    public void doSomething() {
        System.out.println("Do something");
    }

    public static void doSomething2() {
        System.out.println("static");
    }
}
