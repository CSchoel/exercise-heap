package passwords;

import java.util.ArrayList;

public class Passwords {

    private static char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static ArrayList<String> passwords = new ArrayList<>();

    public static ArrayList<String> passwords() {
        generatePasswords("grunz", 9);
        return passwords;
    }

    private static void generatePasswords(String seed, int length) {
        if (seed.length() > length) return;
        passwords.add(seed);
        for (char c : alphabet) {
            generatePasswords(seed + c, length);
        }
    }

}
