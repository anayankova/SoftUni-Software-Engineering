package parkingSystem;


import org.junit.Assert;
import org.junit.Test;

public class SoftParkTest {

  @Test
    public void testValidImplementationConstructor(){
      SoftPark park = new SoftPark();

      int actualParkCount = park.getParking().size();

      Assert.assertEquals(12, actualParkCount);
  }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetParkingMethodShouldThrowException(){
        SoftPark park = new SoftPark();
        park.getParking().remove("A1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParkCarMethodShouldThrowExceptionWhenParkSpotNotExist(){
        SoftPark park = new SoftPark();
        Car car = new Car("Audi", "CA 1390 CA");
        park.parkCar("W1", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParkCarMethodShouldThrowExceptionWhenParkSpotAlreadyTaken(){
        SoftPark park = new SoftPark();
        Car car = new Car("Audi", "CA 1390 CA");
        park.parkCar("A1", car);
        park.parkCar("A1", car);
    }

    @Test
    public void testMessageParkCarMethodWorkCorrectly(){
        SoftPark park = new SoftPark();
        Car car = new Car("Audi", "CA 1390 CA");
        String actualParkCarRes = park.parkCar("A1", car);

        Assert.assertEquals("Car:CA 1390 CA parked successfully!", actualParkCarRes);
    }

    @Test
    public void testParkCarMethodWorkCorrectly(){
        SoftPark park = new SoftPark();
        Car car = new Car("Audi", "CA 1390 CA");
        String actualParkCarRes = park.parkCar("A1", car);

        Assert.assertEquals(car, park.getParking().get("A1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCarMethodShouldThrowExceptionWhenParkSpotNotExist(){
        SoftPark park = new SoftPark();
        Car car = new Car("Audi", "CA 1390 CA");
        park.removeCar("W1", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCarMethodShouldThrowException(){
        SoftPark park = new SoftPark();
        Car car = new Car("Audi", "CA 1390 CA");
        Car carTwo = new Car("BMW", "AA 1390 CA");
        park.parkCar("A1", car);
        park.removeCar("A1", carTwo);
    }

    @Test
    public void testRemoveCarMethodCorrectlyRemoveCarFromCollection(){
        SoftPark park = new SoftPark();
        Car car = new Car("Audi", "CA 1390 CA");
        park.parkCar("A1", car);
        park.removeCar("A1", car);

        Assert.assertNull(park.getParking().get("A1"));
    }

    @Test
    public void testMessageRemoveCarMethodWorkCorrectly(){
        SoftPark park = new SoftPark();
        Car car = new Car("Audi", "CA 1390 CA");
        park.parkCar("A1", car);
        String actualRemoveCarRes = park.removeCar("A1", car);

        Assert.assertEquals("Remove car:CA 1390 CA successfully!", actualRemoveCarRes);
    }


}