package unitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.instrument.UnmodifiableClassException;
import java.util.*;

public class RaceEntryTest {

    private RaceEntry raceEntry;
    private UnitMotorcycle motorcycle;
    private UnitMotorcycle motorcycle2;
    private UnitRider rider;
    private UnitRider rider2;

    @Before
    public void initialize() {
        this.raceEntry = new RaceEntry();
        this.motorcycle = new UnitMotorcycle("harli", 250, 1000);
        this.motorcycle2 = new UnitMotorcycle("pistarka", 500, 1500);
        this.rider = new UnitRider("Ivan", motorcycle);
        this.rider2 = new UnitRider("Gosho", motorcycle2);
    }

    @Test
    public void checkIfConstructorInitializesValidCollection (){
        Assert.assertEquals(0, this.raceEntry.getRiders().size());
    }

    @Test(expected = NullPointerException.class)
    public void addRiderShouldThrowNullPointerExceptionIfRiderIsNull() {
        this.raceEntry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRiderShouldThrowIAExceptionIfRiderAlreadyExists() {
        raceEntry.addRider(this.rider);
        raceEntry.addRider(this.rider);
    }

    @Test
    public void addRiderShouldAddTheRiderToTheCollection (){
        this.raceEntry.addRider(this.rider);

        Assert.assertEquals(1, this.raceEntry.getRiders().size());
    }

    @Test
    public void checkIfAddRiderReturnsProperMessage (){
        String message = this.raceEntry.addRider(this.rider);

        Assert.assertEquals("Rider Ivan added in race.", message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsepowerShouldThrowIAExceptionIfRidersAreUnderMinimumAllowed() {
        this.raceEntry.addRider(rider);
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void checkIfCalculateAverageHorsepowerReturnsProperValue() {

        this.raceEntry.addRider(this.rider);
        this.raceEntry.addRider(this.rider2);

        double averageHorsePower = this.raceEntry.getRiders()
                .stream()
                .mapToInt(r -> r.getMotorcycle().getHorsePower())
                .average()
                .getAsDouble();


        Assert.assertEquals(0.000001, this.raceEntry.calculateAverageHorsePower(), averageHorsePower);
    }

    @Test
    public void checkIfGetRidersReturnProperCollection() {

        this.raceEntry.addRider(this.rider);

        List<UnitRider> actualList = new ArrayList<>();
        actualList.addAll(this.raceEntry.getRiders());

        List<UnitRider> expectedList = new ArrayList<>();
        expectedList.add(this.rider);


        Assert.assertEquals(expectedList, actualList);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void checkIfGetRidersReturnUnmodifiableCollection() {

        this.raceEntry.addRider(this.rider);
        this.raceEntry.getRiders().remove(this.rider);
    }


}
