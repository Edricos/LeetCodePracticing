public class FnQueen {
    static int[] chess = new int[20];
    static int count = 0;

    public void start() {
        int n = 9;
        n_queen(1, n);
    }

    public static void n_queen(int k, int n) {
        if (k > n) {
            print(n);
        } else {
            for (int j = 1; j <= n; j++) {
                if (isSafe(k, j)) {
                    chess[k] = j;
                    n_queen(k + 1, n);
                }
            }
        }
    }

    public static boolean isSafe(int k, int j) {
        for (int i = 1; i < k; i++) {
            if (chess[i] == j || (Math.abs(k - i) == Math.abs(j - chess[i]))) {
                return false;
            }
        }
        return true;
    }

    public static void print(int n) {
        count++;
        System.out.println(count + ": ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (chess[i] == j) {
                    System.out.print("Q ");
                } else System.out.print("x ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
