import java.util.*;

public class Tester {
    static int[] US_DENOMS = {100, 50, 25, 10, 5, 1};
    static int[] CCCP_DENOMS = {100, 50, 20, 15, 10, 5, 3, 2, 1};
    static int[] POW_DENOMS = {64, 32, 16, 8, 4, 2, 1};
    static int[] NO_NICKEL_DENOMS = {100, 50, 25, 10, 1};
    static int[] SOME_DENOMS = {66, 35, 27, 18, 10, 1};

    public static void main(String[] args) {
        int matches = 0;
        System.out.println("Testing change_DP and change_greedy algorithms");
        matches = testAlgs(US_DENOMS);
        System.out.println("Testing set1: " + matches + " in 200 tests");
        matches = testAlgs(CCCP_DENOMS);
        System.out.println("Testing set2: " + matches + " in 200 tests");
        matches = testAlgs(POW_DENOMS);
        System.out.println("Testing set3: " + matches + " in 200 tests");
        matches = testAlgs(NO_NICKEL_DENOMS);
        System.out.println("Testing set4: " + matches + " in 200 tests");
        matches = testAlgs(SOME_DENOMS);
        System.out.println("Testing set5: " + matches + " in 200 tests");
    }

    public static int testAlgs(int[] denoms) {
        int[] dpVal;
        int[] greedyVal;
        int ret = 0;

        for (int i = 1; i <= 200; i++) {
            dpVal = ChangeMaker.change_DP(i, denoms);
            greedyVal = ChangeMaker.change_greedy(i, denoms);
            if (Arrays.equals(dpVal, greedyVal)) {
                ret++;
            }
        }
        return ret;
    }
}
