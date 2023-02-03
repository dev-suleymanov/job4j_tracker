package ru.job4j.early;
public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!isValidateByUpper(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!isValidByLower(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isValidByDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isValidBySpecial(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (isValidByNotSubstrings(password, "qwerty")
                || isValidByNotSubstrings(password, "12345")
                || isValidByNotSubstrings(password, "password")
                || isValidByNotSubstrings(password, "admin")
                || isValidByNotSubstrings(password, "user")) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        if (isValidByNotSpace(password)) {
            throw new IllegalArgumentException("Password dont should contain at space symbol");
        }
        return password;
    }

    public static boolean isValidateByUpper(String password) {
        boolean result = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean isValidByLower(String password) {
        boolean result = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean isValidByDigit(String password) {
        boolean result = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean isValidBySpecial(String password) {
        boolean result = false;
        for (int i = 0; i < password.length(); i++) {
            if (!isLetterOrDigit(password.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean isValidByNotSpace(String password) {
        boolean result = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == ' ') {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean isLetterOrDigit(char symbol) {
        return (symbol >= 'a' && symbol <= 'z')
                || (symbol >= 'A' && symbol <= 'Z')
                || (symbol >= '0' && symbol <= '9');
    }

    public static boolean isValidByNotSubstrings(String password, String substring) {
        return password.toUpperCase().contains(substring.toUpperCase());
    }

    public static void main(String[] args) {
        String password = "Ln2$mU-SerTY12";
        boolean result = isValidByNotSpace(password);
        System.out.println(result);
    }
}
