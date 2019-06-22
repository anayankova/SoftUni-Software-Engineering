package arena;

public class Stat {
   private int strength;
   private int flexibility;
   private int agility;
   private int skills;
   private int intelligence;

    public Stat(int strength, int flexibility, int agility, int skills, int intelligence) {
        this.strength = strength;
        this.flexibility = flexibility;
        this.agility = agility;
        this.skills = skills;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getFlexibility() {
        return this.flexibility;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getSkills() {
        return this.skills;
    }

    public int getIntelligence() {
        return this.intelligence;
    }
}
