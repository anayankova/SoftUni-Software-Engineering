package f_DefiningClasses.CatLady;

public class StreetExtraordinaire {
    private String name;
    private  double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        this.name = name;
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public String getName() {
        return this.name;
    }

    public double getDecibelsOfMeows() {
        return this.decibelsOfMeows;
    }
}
