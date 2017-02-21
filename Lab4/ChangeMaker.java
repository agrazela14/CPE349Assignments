public class ChangeMaker {
    public static void main(String[] args) {
        int[] input = {100, 25, 10, 5, 1};
        int n = 233;
        int optimalCoins = 0;
        int[] output = change_greedy(n, input);
        System.out.println("Amount: " + n);
        System.out.print("Optimal Distribution: ");
        for (int i = 0; i < output.length; i++) {
            if (output[i] > 0) {
                System.out.print(output[i] + "*" + input[i] + "c");
                if (input[i] != 1) {
                    System.out.print(" + ");
                }
            }
            optimalCoins += output[i];
        }
        System.out.println();
        System.out.println("Optimal coin count: " + optimalCoins);
    }

    public static int[] change_DP(int n, int[] d) {
        return new int[1];//placeholder, of course

    }

    public static int[] change_greedy(int n, int[] d) {
        int[] ret = new int[d.length]; 
        for (int i = 0; i < d.length; i++) {
            ret[i] = n / d[i];
            n -= ret[i] * d[i];
        } 
        return ret;
    }
} 
