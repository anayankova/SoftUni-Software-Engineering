package b_DataTypesAndVariables;

public class demo15String {
    public static void main(String[] args) {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String fullName = String.format(
                "%s %s", firstName, lastName);
        System.out.printf("Your full name is %s.", fullName);


    }
}
