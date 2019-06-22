package g_Generics.JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<String> jar = new Jar<>();

        jar.add("Pesho");
        jar.add("Pesho1");
        jar.add("Pesho2");
        jar.add("Pesho3");
        System.out.println(jar.remove());
    }
}
