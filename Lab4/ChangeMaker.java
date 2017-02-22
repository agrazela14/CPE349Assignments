public class ChangeMaker {
    public static void main(String[] args) {
        int[] input = {100, 25, 10, 5, 1};
        int n = 233;
        int optimalCoins = 0;
        int[] output = change_DP(n, input);
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

        optimalCoins = 0;
        output = change_greedy(n, input);
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
        int A[], C[], toRet[], min, iMin, ndx;
        A = new int[n+1];
        C = new int[n+1];

        C[0] = 0;
        for(int j = 1; j <= n; j++) {
            //find one subsolution
            min = C[j-1];
            iMin = d.length - 1;
            for(int i = 0; i < d.length; i++) {
                //find min
                if(j - d[i] >= 0) {
                    if(C[j - d[i]] < min) {
                        min = C[j - d[i]];
                        iMin = i;
                    }
                } 
            }
            A[j] = iMin;
            C[j] = 1 + C[j - d[iMin]];
        }

        toRet = new int[d.length];
        ndx = A.length-1;
        while(ndx > 0) {
            toRet[A[ndx]]++;
            ndx -= d[A[ndx]];
        }
        return toRet;

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
