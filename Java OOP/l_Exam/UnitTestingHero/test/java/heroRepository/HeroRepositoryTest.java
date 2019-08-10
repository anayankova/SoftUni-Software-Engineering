package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class HeroRepositoryTest {
    private static final String HERO_NAME = "A";
    private static final int HERO_LEVEL_LOWEST = 60;
    private static final int INTELLIGENCE = 10;
    private static final int AGILITY = 1;
    private static final int STRENGTH = 15;
    private static final Item ITEM = new Item(STRENGTH, AGILITY, INTELLIGENCE);
    private static final Hero HERO = new Hero(HERO_NAME, HERO_LEVEL_LOWEST, ITEM);
    private static final int A_HERO_ADDED_SIZE = 1;
    private static final String TO_STRING = String.format("Hero: %s – %d%n" +
                    "  *  Strength: %d%n" +
                    "  *  Agility: %d%n" +
                    "  *  Intelligence: %d%n", HERO_NAME, HERO_LEVEL_LOWEST,
            STRENGTH, AGILITY, INTELLIGENCE);

    private static final Hero NEGATIVE_STRENGTH_HERO = new Hero("Hero", 1, new Item(-1, 1, 1));
    private static final Hero NEGATIVE_AGILITY_HERO = new Hero("Hero", 1, new Item(1, -1, 1));
    private static final Hero NEGATIVE_INTELLIGENCE_HERO = new Hero("Hero", 1, new Item(1, 1, -1));


    private HeroRepository repository;

    @Before
    public void init() {
        this.repository = new HeroRepository();
    }

    @Test
    public void shouldAddHeroSuccessfully() {
        this.repository.add(HERO);
        int expectedSize = A_HERO_ADDED_SIZE;
        Assert.assertEquals(expectedSize, this.repository.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenAddingAlreadyExistingHero() {
        this.repository.add(HERO);
        this.repository.add(HERO);
    }

    @Test
    public void shouldRemoveHeroFromRepository() {
        this.repository.add(HERO);
        this.repository.remove(HERO_NAME);
        int actualSize = this.repository.getCount();
        Assert.assertEquals(0, actualSize);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenRemoveNonExistingHero() {
        this.repository.remove(HERO_NAME);
    }

    @Test
    public void shouldReturnCorrectHeroWithHighestStrength() {
        this.repository.add(HERO);
        Hero hero = this.repository.getHeroWithHighestStrength();

        Assert.assertEquals(HERO, hero);
    }


    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenNoHigherWithHighestStrengthFound() {
        this.repository.add(NEGATIVE_STRENGTH_HERO);
        this.repository.getHeroWithHighestStrength();
    }

    @Test
    public void shouldReturnCorrectHeroWithHighestAgility() {
        this.repository.add(HERO);
        Hero hero = this.repository.getHeroWithHighestAgility();

        Assert.assertEquals(HERO, hero);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenNoHeroWithHighestAgilityFound() {

        this.repository.add(NEGATIVE_AGILITY_HERO);
        this.repository.getHeroWithHighestAgility();
    }

    @Test
    public void shouldReturnCorrectHeroWithHighestIntelligence() {
        this.repository.add(HERO);
        Hero hero = this.repository.getHeroWithHighestIntelligence();

        Assert.assertEquals(HERO, hero);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenNoHeroWithHighestIntelligenceFound() {
        this.repository.add(NEGATIVE_INTELLIGENCE_HERO);
        this.repository.getHeroWithHighestIntelligence();
    }

    @Test
    public void shouldReturnCorrectHeroInformationAsString() {
        this.repository.add(HERO);
        String actual = this.repository.toString();
        Assert.assertEquals(TO_STRING, actual);
    }
}