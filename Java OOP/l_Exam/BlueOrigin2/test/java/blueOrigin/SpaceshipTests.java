package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private static final String INVALID_SPACESHIP_NAME = "Invalid spaceship name!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";
    private static final String SPACESHIP_FULL = "Spaceship is full!";
    private static final String ASTRONAUT_EXIST = "Astronaut %s is already in!";

    private static final String ASTRONAUT_NAME = "A";
    private static double oxygen = 50.0;
    private static final Astronaut ASTRONAUT = new Astronaut(ASTRONAUT_NAME, oxygen);
    private Spaceship spaceship;
    private static final int CAPACITY = 2;
    private static final String SPACE_SHIP_NAME = "NAME";
    private static final String TEST_ASTRONAUT_NAME = "B";
    private static final double TEST_OXYGEN = 60;
    private static final Astronaut TEST_ASTRONAUT = new Astronaut(TEST_ASTRONAUT_NAME, TEST_OXYGEN);

    @Before
    public void init() {
        this.spaceship = new Spaceship(SPACE_SHIP_NAME, CAPACITY);
        this.spaceship.add(ASTRONAUT);
    }

    @Test
    public void shouldReturnCorrectAstronautsSize () {
        int actual = this.spaceship.getCount();
        Assert.assertEquals(1, actual);
    }

    @Test
    public void shouldReturnCorrectName() {
        String actual = this.spaceship.getName();
        Assert.assertEquals(SPACE_SHIP_NAME, actual);
    }

    @Test
    public void shouldReturnCorrectCapacity () {
        int actual = this.spaceship.getCapacity();
        Assert.assertEquals(CAPACITY, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenCapacityFull () {
        this.spaceship.add(TEST_ASTRONAUT);
        this.spaceship.add(TEST_ASTRONAUT);
    }

    @Test
    public void fullShouldThrowCorrectMessage () {
        this.spaceship.add(TEST_ASTRONAUT);
        String actual = "";
        try {
            this.spaceship.add(TEST_ASTRONAUT);
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }
        Assert.assertEquals(SPACESHIP_FULL, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenAstronautExists() {
        this.spaceship.add(ASTRONAUT);
    }

    @Test
    public void shouldThrowCorrectMessageAlreadyAdded () {

        String actual = "";
        try {
            this.spaceship.add(ASTRONAUT);
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }
        Assert.assertEquals(String.format(ASTRONAUT_EXIST, ASTRONAUT_NAME), actual);
    }

    @Test
    public void shouldRemoveAstronaut() {
        boolean actual = this.spaceship.remove(ASTRONAUT_NAME);
        Assert.assertTrue(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowSetCapacity() {
        this.spaceship = new Spaceship(SPACE_SHIP_NAME, -1);
    }

    @Test
    public void shouldThrowSetCapacityCorrectMessage() {
        String actual = "";
        try {
            this.spaceship = new Spaceship(SPACE_SHIP_NAME, -1);
        } catch (IllegalArgumentException e) {
            actual = e.getMessage();
        }
        Assert.assertEquals(INVALID_CAPACITY, actual);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowWhenNullName() {
        this.spaceship = new Spaceship(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowEmpty() {
        this.spaceship = new Spaceship(" ", CAPACITY);
    }

    @Test
    public void returnCorrectMessage() {
        String actual = "";
        try {
            this.spaceship = new Spaceship(" ", CAPACITY);
        }catch (NullPointerException e) {
            actual = e.getMessage();
        }
        Assert.assertEquals(INVALID_SPACESHIP_NAME, actual);
    }

    @Test
    public void returnCorrectMessageWhenNull() {
        String actual = "";
        try {
            this.spaceship = new Spaceship(null, CAPACITY);
        }catch (NullPointerException e) {
            actual = e.getMessage();
        }
        Assert.assertEquals(INVALID_SPACESHIP_NAME, actual);
    }
}
