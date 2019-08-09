package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database db;

    private static final int INVALID_MAX_ELEMENT_COUNT  = 17;

    private static final Integer[] INITIAL_ELEMENTS = {
            13, 42, 69, 73
    };

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.db = new Database(INITIAL_ELEMENTS);
    }

    @Test
    public void creatingDatabaseShouldSetElementsCorrectly() throws OperationNotSupportedException {
        Assert.assertArrayEquals(this.db.getElements(), INITIAL_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithZeroElementsShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingDatabaseWithMoreThanSixteenElementsShouldThrowException() throws OperationNotSupportedException {
        Database db = new Database(new Integer[INVALID_MAX_ELEMENT_COUNT]);
    }

    @Test
    public void addingElementShouldAddCorrectly() throws OperationNotSupportedException {
        this.db.add(17);
        Assert.assertEquals(this.db.getElements().length, INITIAL_ELEMENTS.length + 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullShouldThrowAnException() throws OperationNotSupportedException {
        this.db.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingFromEmptyDatabaseShouldThrowAnException() throws OperationNotSupportedException {
        Integer[] elements = this.db.getElements();
        for (int i = 0; i < elements.length; i++) {
            this.db.remove();
        }
        this.db.remove();
    }

    @Test
    public void removeShouldDecreaseElementsCount() throws OperationNotSupportedException {
        this.db.remove();
        Assert.assertEquals(this.db.getElements().length, INITIAL_ELEMENTS.length-1);
    }

}