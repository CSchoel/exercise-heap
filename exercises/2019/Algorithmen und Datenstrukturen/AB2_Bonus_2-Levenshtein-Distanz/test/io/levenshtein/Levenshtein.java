package io.levenshtein;

public class Levenshtein {

    public static void main(String[] args) {
        System.out.println(distance("meilenstein", "io/levenshtein"));
    }

    public static int distance(String word1, String word2) {
        word1 = " " + word1;
        word2 = " " + word2;
        int n = word1.length();
        int m = word2.length();
        if (n == 0) return m;
        if (m == 0) return n;
        Integer[][] matrix = new Integer[n][m];
        for (int i = 0; i < n; i++) matrix[i][0] = i;
        for (int i = 0; i < m; i++) matrix[0][i] = i;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int cost = (word1.charAt(i) == word2.charAt(j)) ? 0 : 1;
                int value = Math.min(Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1), matrix[i - 1][j - 1] + cost);
                matrix[i][j] = value;
            }
        }
        /*
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%d, ", matrix[j][i]));
            }
            System.out.println();
        }
        */
        return matrix[n - 1][m - 1];
    }
}
