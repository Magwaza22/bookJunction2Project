package za.ac.cput.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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

    public static boolean isValidEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static boolean isValidId(Object adminId) {
        return false;
    }
}

