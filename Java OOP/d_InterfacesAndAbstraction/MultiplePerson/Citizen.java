package d_InterfacesAndAbstraction.MultiplePerson;

public class Citizen implements Person, Identifiable, Birthable{
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String toString(){
        return String.format("Citizen %s is %d years old and has %s id and birth date: %s",
                this.getName(),this.getAge(),this.getId(),this.getBirthDate());
    }
}
