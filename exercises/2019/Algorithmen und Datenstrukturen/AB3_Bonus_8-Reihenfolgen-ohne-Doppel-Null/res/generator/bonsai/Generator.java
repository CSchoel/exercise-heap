package bonsai;

import java.util.Random;

public final class Generator {
	private static final Random random = new Random();

	private Generator() {}

	public static void main(final String[] arguments) {
		int a;  // Anzahl Nullen
		int b;  // Anzahl Einsen
		for(int i = 0; i < 100; i++) {
			a = random.nextInt(20);
			b = random.nextInt(10) + a - 1;  // a <= b - 1 (damit die möglichen Kombinationen > 0 sind)
			System.out.println(a + ";" + b);
		}
	}

}
