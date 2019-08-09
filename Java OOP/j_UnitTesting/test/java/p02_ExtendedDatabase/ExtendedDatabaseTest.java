package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {

    private static final String[] NAMES = {
        "A","B","C","D","E"
    };

    private Database db;

    @Before
    public void createDatabase() throws OperationNotSupportedException {

        Person[] people = new Person[5];

        for (int i = 0; i < 5; i++) {
            people[i] = new Person(i+1, NAMES[i]);
        }

        this.db = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUserNameShouldThrowAnExceptionWhenCalledWithNull() throws OperationNotSupportedException {
        this.db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUserNameShouldThrowAnExceptionWithDuplicatedUserNames() throws OperationNotSupportedException {
        this.db.add(new Person(12,"B"));
        this.db.findByUsername("B");
    }

    @Test
    public void findByUsernameShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person found = this.db.findByUsername("B");
        boolean areEqual = found.getId() == 2 && found.getUsername().equals("B");
        Assert.assertTrue(areEqual);
    }

    @Test
    public void findByUsernameShouldBeCaseSensitive() throws OperationNotSupportedException {
        this.db.add(new Person(69,"b"));
        Person found = this.db.findByUsername("b");
        boolean areEqual = found.getId() == 69 && found.getUsername().equals("b");
        Assert.assertTrue(areEqual);
    }



}