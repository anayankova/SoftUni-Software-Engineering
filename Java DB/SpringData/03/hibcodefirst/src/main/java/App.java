import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    private static final String GRINGOTTS_DB = "gringotts";
    private static final String SALES_DB = "sales";
    private static final String UNIVERSITY_DB = "university";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(UNIVERSITY_DB);

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Engine engine = new Engine(entityManager);
//
//        engine.run();

    }
}
