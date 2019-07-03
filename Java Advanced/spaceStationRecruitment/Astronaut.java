package spaceStationRecruitment;

public class Astronaut {
    private String name;
    private int age;
    private String country;

    public Astronaut(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString(){
        return String.format("Astronaut: %s, %d (%s)", this.name, this.age, this.country);
    }
}
