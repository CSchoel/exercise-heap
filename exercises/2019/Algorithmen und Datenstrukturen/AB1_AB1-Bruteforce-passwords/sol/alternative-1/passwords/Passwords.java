package passwords;

import java.util.ArrayList;

public class Passwords {

	public static ArrayList<String> passwords() {
		int maxCombinations =
			(int) Math.pow(52, 4) + // all passwords with length 9
			(int) Math.pow(52, 3) + // all passwords with length 8
			(int) Math.pow(52, 2) + // all passwords with length 7
			(int) Math.pow(52, 1) + // all passwords with length 6
			(int) Math.pow(52, 0);  // all passwords with length 5
		ArrayList<String> passwords = new ArrayList<>(maxCombinations);

		String[] letters = new String[52];
		for (char c = 'a'; c <= 'z'; c++) {
			letters[c - 'a'] = Character.toString(c);
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			letters[c - 'A' + 26] = Character.toString(c);
		}

		passwords.add("grunz"); // all passwords with length 5
		for (int i = 0; i < letters.length; i++) {
			final String is = "grunz" + letters[i];
			passwords.add(is); // all passwords with length 6

			for (int j = 0; j < letters.length; j++) {
				final String js = is + letters[j];
				passwords.add(js); // all passwords with length 7

				for (int k = 0; k < letters.length; k++) {
					final String ks = js + letters[k];
					passwords.add(ks); // all passwords with length 8

					for (int l = 0; l < letters.length; l++) {
						passwords.add(ks + letters[l]); // all passwords with length 9
					}
				}
			}
		}

		return passwords;
	}

}
