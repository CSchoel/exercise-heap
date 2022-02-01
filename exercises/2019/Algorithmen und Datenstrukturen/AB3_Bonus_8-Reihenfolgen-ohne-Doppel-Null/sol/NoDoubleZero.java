public class NoDoubleZero {
    private int f(int a, int b) {
        if (a > b + 1) return 0;
        if (a == 0 || b == 0) return 1;
        return f(a, b - 1) + f(a - 1, b - 1);
    }
    public static void main(String[] args) {
        System.out.println(f(12, 20));
    }
}
