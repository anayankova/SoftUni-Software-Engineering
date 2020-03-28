import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "minions_db";

    private static Connection connection;
    private static String query;
    private static PreparedStatement statement;
    private static BufferedReader reader;

    public static void main(String[] args) throws SQLException, IOException {

        reader = new BufferedReader(new InputStreamReader(System.in));

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", Password.getPass());

        connection = DriverManager.getConnection(CONNECTION_STRING + DATABASE_NAME, properties);

        //2.	Get Villains’ Names
        //getVillainsNamesAndCountOfMinions();

        //3.	Get Minion Names
        //getMinionNamesEx();

        //4.	Add Minion
        //addMinionEx();

        //5.	Change Town Names Casing
        //changeTownNamesCasing();

        //7.	Print All Minion Names
        //printAllMinionNames();

        //8.	Increase Minions Age
        //increaseMinionsAge();

        //9.	Increase Age Stored Procedure
        //increaseAgeStoredProcedure();

        //query = "SELECT name FROM minions";
        //statement = connection.prepareStatement(query);

        //ResultSet resultSet = statement.executeQuery();

        //while (resultSet.next()) {
        //System.out.printf("%s %n", resultSet.getString(1));
        //}
    }

    private static void increaseMinionsAge() throws IOException, SQLException {
        System.out.println("Enter minion IDs:");
        int[] minionIDs = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < minionIDs.length; i++) {
            incrementMinionAgeById(minionIDs[i]);
        }
        query = "SELECT name, age FROM minions";

        statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString(1),
                    resultSet.getInt(2));
        }
    }

    private static void incrementMinionAgeById(int minionID) throws SQLException {
        query = "UPDATE minions\n" +
                "SET age = age + 1, name = LOWER(name)\n" +
                "WHERE id = ?;";

        statement = connection.prepareStatement(query);
        statement.setInt(1, minionID);

        statement.execute();
    }

    private static void printAllMinionNames() throws SQLException {
        query = "SELECT name FROM minions";

        statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<String> names = new ArrayList<>();
        while (resultSet.next()) {
            names.add(resultSet.getString(1));
        }
        for (int i = 0; i < names.size() / 2; i++) {
            if (names.size() % 2 == 0) {
                System.out.println(names.get(i));
                System.out.println(names.get(names.size() - 1 - i));
            } else {
                while (i <= names.size() / 2 - 1) {
                    System.out.println(names.get(i));
                    System.out.println(names.get(names.size() - 1 - i));
                }
                System.out.println(names.get(i));
            }
        }
    }

    private static void changeTownNamesCasing() throws IOException, SQLException {
        System.out.println("Enter country:");
        String country = reader.readLine();

        updateEntityInTowns(country);

        query = "SELECT name FROM towns WHERE country = ?";

        statement = connection.prepareStatement(query);
        statement.setString(1, country);
        ResultSet resultSet = statement.executeQuery();

        if (!checkIfEntityExistsByCountry(country, "towns")) {
            System.out.println("No town names were affected.");
        } else {
            int count = 0;
            List<String> updatedTowns = new ArrayList<>();
            while (resultSet.next()) {
                count++;
                updatedTowns.add(resultSet.getString(1));
            }
            System.out.printf("%d town names were affected.%n", count);
            System.out.println(updatedTowns);
        }
    }

    private static void increaseAgeStoredProcedure() throws IOException, SQLException {
        System.out.println("Enter minion id:");
        int minionId = Integer.parseInt(reader.readLine());

        query = "CALL usp_get_older(?)";

        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1, minionId);
        callableStatement.execute();
    }

    private static void addMinionEx() throws IOException, SQLException {
        System.out.println("Enter minion parameters:");

        String[] minionParameters = reader.readLine().split("\\s+");
        String minionName = minionParameters[0];
        int minionAge = Integer.parseInt(minionParameters[1]);
        String minionTown = minionParameters[2];

        System.out.println("Enter villain name:");
        String vilainName = reader.readLine();

        if (!checkIfEntityExistsByName(minionTown, "towns")) {
            insertEntityInTowns(minionTown);
        }
    }

    private static void updateEntityInTowns(String country) throws SQLException {
        query = "UPDATE towns\n" +
                "SET name = UPPER(name)\n" +
                "WHERE country = ?;";

        statement = connection.prepareStatement(query);
        statement.setString(1, country);

        statement.execute();
    }

    private static void insertEntityInTowns(String minionTown) throws SQLException {
        query = "INSERT INTO towns (name, country) VALUE(?, ?)";

        statement = connection.prepareStatement(query);
        statement.setString(1, minionTown);
        statement.setString(2, "NULL");

        statement.execute();
    }

    private static boolean checkIfEntityExistsByName(String entityName, String tableName) throws SQLException {
        query = "SELECT * FROM " + tableName + " WHERE name = ?";

        statement = connection.prepareStatement(query);
        statement.setString(1, entityName);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }

    private static boolean checkIfEntityExistsByCountry(String entityCountry, String tableName) throws SQLException {
        query = "SELECT * FROM " + tableName + " WHERE country = ?";

        statement = connection.prepareStatement(query);
        statement.setString(1, entityCountry);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }

    private static void getMinionNamesEx() throws IOException, SQLException {
        System.out.println("Enter villain id:");
        int villain_id = Integer.parseInt(reader.readLine());

        if (!checkIfEntityExists(villain_id, "villains")) {
            System.out.printf("No villain with ID %d exists in the database.", villain_id);
            return;
        }

        System.out.printf("Villain: %s%n", getEntityNameById(villain_id, "villains"));
        getMinionsAndAgeByVillainId(villain_id);
    }

    private static void getMinionsAndAgeByVillainId(int villain_id) throws SQLException {
        query = "SELECT m.name, m.age FROM minions AS m\n" +
                "JOIN minions_villains mv on m.id = mv.minion_id\n" +
                "WHERE mv.villain_id = ?;";

        statement = connection.prepareStatement(query);
        statement.setInt(1, villain_id);

        ResultSet resultSet = statement.executeQuery();
        int minionNumber = 0;

        while (resultSet.next()) {
            System.out.printf("%d. %s %d%n", ++minionNumber,
                    resultSet.getString("name"), resultSet.getInt(2));
        }
    }

    private static String getEntityNameById(int entityId, String tableName) throws SQLException {
        query = "SELECT name FROM " + tableName + " WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, entityId);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getString("name") : null;
    }

    private static boolean checkIfEntityExists(int villain_id, String villains) throws SQLException {
        query = "SELECT * FROM " + villains + " WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, villain_id);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }

    private static void getVillainsNamesAndCountOfMinions() throws SQLException {
        query = "SELECT v.name, COUNT(mv.minion_id) AS 'count'\n" +
                "FROM villains AS v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "GROUP BY v.name\n" +
                "HAVING `count` > 15\n" +
                "ORDER BY `count` DESC";

        statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString(1),
                    resultSet.getInt(2));
        }
    }
}
