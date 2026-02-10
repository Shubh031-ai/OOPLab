import java.util.Scanner;

public class passwordCheck {

    public static boolean checkPassword(String password) {
        if (password.length() < 5 || password.length() > 12) {
            return false;
        }

        boolean hasLower = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                return false;
            }

            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }

            if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        if (!hasLower || !hasDigit) {
            return false;
        }

        for (int len = 1; len <= password.length() / 2; len++) {
            for (int i = 0; i <= password.length() - 2 * len; i++) {
                String sub1 = password.substring(i, i + len);
                String sub2 = password.substring(i + len, i + 2 * len);

                if (sub1.equals(sub2)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] tests = { "abcanan1", "abc11se", "123sd123", "adfasdsdf", "Aasdfasd12" };

        for (String t : tests) {
            System.out.println(t + " : " + (checkPassword(t) ? "Acceptable" : "Not Acceptable"));
        }
    }
}