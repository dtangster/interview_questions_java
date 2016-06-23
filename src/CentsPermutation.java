public class CentsPermutation {
    public static int getWaysToGenerateCents(int n) {
       return _getWaysToGenerateCents(n, 25);
    }

    private static int _getWaysToGenerateCents(int n, int denom) {
        if (n < 0) {
            return 0;
        }

        int count = 0;

        switch (denom) {
            case 25:
                count += _getWaysToGenerateCents(n - 25, 25);
            case 10:
                count += _getWaysToGenerateCents(n - 10, 10);
            case 5:
                count += _getWaysToGenerateCents(n - 5, 5);
            case 1:
                count += 1;
        }

        return count;
    }

    public static void main(String [] args) {
        System.out.println(CentsPermutation.getWaysToGenerateCents(5));
    }
}
