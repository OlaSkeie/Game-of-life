public class In1150 {
    public static void main(String[] args){
        int combinations = countCombinations(101, 3, 1, 50);
        System.out.println(combinations);
    }
    public static int countCombinations(int n, int k, int min, int max) {
        if (n == 0 && k == 0) {
            return 1;
        } else if (n <= 0 || k <= 0) {
            return 0;
        } else {
            int sum = 0;
            for (int i = min; i <= max; i++) {
                sum += countCombinations(n - i, k - 1, min, max);
            }
            return sum;
        }
    }
    
    
}
