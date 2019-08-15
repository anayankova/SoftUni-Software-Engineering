package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    @Test
    public void constructor_ShouldSetSuccessfullyValues() {
        Spaceship spaceship = new Spaceship("ElonMusk", 10);

        String expectedName = "ElonMusk";
        int expectedCapacity = 10;

        String actualName = spaceship.getName();
        int actualCapacity = spaceship.getCapacity();

        Assert.assertEquals(expectedCapacity, actualCapacity);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected = NullPointerException.class)
    public void constructor_ShouldThrowArgumentNullExceptionForInvalidName() {
        new Spaceship(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_ShouldThrowArgumentExceptionForInvalidCapacity() {
        new Spaceship("Peter", -10);
    }

    @Test
    public void addMethod_ShouldAddSuccessfully() {
        Spaceship spaceship = new Spaceship("ElonMusk", 10);
        Astronaut astronaut = new Astronaut("Kiro", 20);

        spaceship.add(astronaut);

        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethod_ShouldThrowsExceptionForInvalidCapacity() {
        Spaceship spaceship = new Spaceship("ElonMusk", 0);
        Astronaut astronaut = new Astronaut("Mike", 20);

        spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethod_ShouldThrowsExceptionForDuplicateAstronaut() {
        Spaceship spaceship = new Spaceship("ElonMusk", 2);
        Astronaut astronaut = new Astronaut("Mike", 20);

        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test
    public void removeMethod_ShouldReturnTrueIfAstronautIsFound() {
        Spaceship spaceship = new Spaceship("ElonMusk", 2);
        Astronaut astronaut = new Astronaut("Mike", 20);

        spaceship.add(astronaut);

        boolean isRemove = spaceship.remove("Mike");

        Assert.assertTrue(isRemove);
        Assert.assertEquals(0, spaceship.getCount());
    }
}
