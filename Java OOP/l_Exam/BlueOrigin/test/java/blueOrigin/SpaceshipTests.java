package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Spaceship spaceship;
    private Astronaut astronaut1;
    private Astronaut astronaut2;

    @Before
    public void initialize(){
        this.spaceship = new Spaceship("A", 2);
        this.astronaut1 = new Astronaut("A", 12.0);
        this.astronaut2 = new Astronaut("B", 13.0);
    }

    @Test
    public void getCountMethodValidImplementation(){
        this.spaceship.add(astronaut1);
        this.spaceship.add(astronaut2);
        int size = this.spaceship.getCount();
        Assert.assertEquals(2,size);
    }

    @Test
    public void getNameMethodValidImplementation(){
        this.spaceship = new Spaceship("A", 2);
        Assert.assertEquals("A", this.spaceship.getName());
    }

    @Test
    public void getCapacityMethodValidImplementation(){
        this.spaceship = new Spaceship("A", 2);
        Assert.assertEquals(2, this.spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethodShouldThrowExceptionIfSpaceShipIsFull(){
        this.spaceship = new Spaceship("A", 1);
        this.spaceship.add(astronaut1);
        this.spaceship.add(astronaut2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethodShouldThrowExceptionIfAstronautExist(){
        this.spaceship.add(astronaut1);
        this.spaceship.add(astronaut1);
    }

    @Test
    public void addMethodWorkCorrectly(){
        this.spaceship.add(astronaut1);
        Assert.assertEquals("A",this.astronaut1.getName());
    }

    @Test
    public void removeMethodWorkCorrectly(){
        this.spaceship.add(astronaut1);
        this.spaceship.remove("A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityMethodShouldThrowException(){
        this.spaceship = new Spaceship("A", -1);
    }

    @Test
    public void setCapacityMethodWorkCorrectly(){
        this.spaceship = new Spaceship("A", 1);
        Assert.assertEquals(1, this.spaceship.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void setNameMethodShouldThrowException(){
        this.spaceship = new Spaceship(null, 1);
    }

    @Test
    public void setNameMethodWorkCorrectly(){
        this.spaceship = new Spaceship("A", 1);
        Assert.assertEquals("A", this.spaceship.getName());
    }

    @Test(expected = NullPointerException.class)
    public void setNameMethodShouldThrowExceptionIf(){
        this.spaceship = new Spaceship(" ", 1);
    }


}
