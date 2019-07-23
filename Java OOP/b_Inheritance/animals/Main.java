package b_Inheritance.animals;

public class Main {
    public static void main(String[] args) {
        //Animal animal = new Animal() {
        //    @Override
        //    public String produceSound() {
        //        return null;
        //    }
        //}

        //Animal dog = new Dog("Sharo", 97, "Male");

       // System.out.println(dog.produceSound());

        Cat cat = new Kitten("1234",150);

        System.out.println(cat.toString());

    }
}
