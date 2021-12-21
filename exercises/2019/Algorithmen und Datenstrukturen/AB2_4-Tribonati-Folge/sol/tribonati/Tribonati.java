package tribonati;

public class Tribonati {

  // Tribonacci-Folge
  // 0, 1, 1, 2, 4, 7, 13, 24, ...
  // a_n = a_n-1 + a_n-2 + a_n-3

  // Aufgabe 1
  public static long tribDyn(int n, long[] brain) {
    if(brain.length > 3 && brain[n] > 1) return brain[n];
    long res = 0;
    if(n < 2) res = n;
    else if(n == 2) res = 1;
    else res = tribDyn(n-1, brain) + tribDyn(n-2, brain) + tribDyn(n-3, brain);
    brain[n] = res;
    return res;
  }

  // Zum Zeitvergleich:

  // Ohne Dynamische Programmierung
  private static long trib(int n) {
    if(n < 2) return n;
    else if(n == 2) return 1;
    else return trib(n-1) + trib(n-2) + trib(n-3);
  }

  /*
  public static void main(String[] args) {
    long timeStart = 0;
    long timeEnd = 0;
    timeStart = System.currentTimeMillis();
    System.out.println("Without DP: " + trib(20));
    timeEnd = System.currentTimeMillis();
    System.out.println((timeEnd - timeStart) + " ms");
    timeStart = System.currentTimeMillis();
    System.out.println("With DP: " + tribDyn(20, new int[21]));
    timeEnd = System.currentTimeMillis();
    System.out.println((timeEnd - timeStart) + " ms");
  }
  */
}
