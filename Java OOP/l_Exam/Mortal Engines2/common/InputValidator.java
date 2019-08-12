package common;

public class InputValidator {

    public static boolean isValidPilotName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidMachineName(String name) {
        return name != null && !name.trim().isEmpty();
    }
}