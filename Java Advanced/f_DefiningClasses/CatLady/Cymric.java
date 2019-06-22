package f_DefiningClasses.CatLady;

public class Cymric {
    private String name;
    private  double furLength;

    public Cymric(String name, double furLength) {
        this.name = name;
        this.furLength = furLength;
    }

    public String getName() {
        return this.name;
    }

    public double getFurLength() {
        return this.furLength;
    }
}


//public class Cymric extends Cat{
//    public Cymric (String name, double skillValue){
//        super(name, skillValue);
//    }
//}
//
//public class Cat {
//    private String name;
//    private  double skillValue;
//
//    public Cat(String name, double skillValue) {
//        this.name = name;
//        this.skillValue = skillValue;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public double getSkillValue() {
//        return this.skillValue;
//    }
//}