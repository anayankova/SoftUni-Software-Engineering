package heroRepository;

import org.junit.Assert;
import org.junit.Test;

public class HeroRepositoryTests {
    @Test
    public void HeroRepositoryMethodImplementSuccessfully() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("A", 1);
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void createMethodShouldThrowNullPointerExceptionWhenHeroIsNull() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = null;
        heroRepository.create(hero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createMethodShouldThrowNIllegalArgumentExceptionWhenHeroAlreadyExist() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1 = new Hero("A", 1);
        Hero hero2 = new Hero("A", 1);
        heroRepository.create(hero1);
        heroRepository.create(hero2);
    }

    @Test
    public void createMethodImplementSuccessfully() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("A", 1);
        String message = heroRepository.create(hero);
        Assert.assertEquals("Successfully added hero A with level 1", message);
    }

    @Test(expected = NullPointerException.class)
    public void removeMethodShouldThrowNullPointerExceptionWhenHeroNameIsNull() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero(null, 1);
        heroRepository.create(hero);
        heroRepository.remove(hero.getName());
    }

    @Test(expected = NullPointerException.class)
    public void removeMethodShouldThrowNullPointerExceptionWhenHeroNameIsEmpty() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero(" ", 1);
        heroRepository.create(hero);
        heroRepository.remove(hero.getName());
    }

    @Test
    public void removeMethodShouldReturnTrueIfHeroIsFound() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("A", 1);

        heroRepository.create(hero);

        boolean isRemove = heroRepository.remove("A");

        Assert.assertTrue(isRemove);
        Assert.assertEquals(0, heroRepository.getCount());
    }

    @Test
    public void getHeroWithHighestLevelMethodImplementSuccessfully() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero1 = new Hero("A", 1);
        Hero hero2 = new Hero("B", 2);
        Hero hero3 = new Hero("C", 3);
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);

        Assert.assertEquals(hero3, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void getHeroMethodImplementSuccessfully() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("A", 1);
        heroRepository.create(hero);

        Assert.assertEquals(hero, heroRepository.getHero("A"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getHeroesMethodShouldThrowException(){
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.getHeroes().remove("A");
    }


}
