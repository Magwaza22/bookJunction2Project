package za.ac.cput.util;

import java.util.UUID;

public class Helper {

    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty())
            return true;
        return false;
    }

    public static String generatedID() {
        return UUID.randomUUID().toString();
    }

    public static boolean assertInRange(int i) {
        if (i >= 1 && i <= 5) {
            return true;
        }
        return false;
    }

    public static boolean generateId() {
        return true;
    }

}
