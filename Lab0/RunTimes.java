import java.util.*;

public class RunTimes {

    public static void main(String args[]) {
        RunLog();
        System.out.println();
        RunLinear();
        System.out.println();
        RunNlogN();
        System.out.println();
        RunQuadratic();
        System.out.println();
        RunCubic();
    }

    private static void RunLinear() {
        long startTime;
        long endTime;
        long runTime;
        System.out.println("Linear algorithm's running times:");

        for (long i = 1000; i < 100000000; i *= 2) {
            startTime = System.nanoTime();
            Algorithms.linearAlgorithm(i);
            endTime = System.nanoTime();
            runTime = endTime - startTime;
            runTime /= 1000000;
            System.out.println("T(" + i + ") = " + runTime);
        }
    }

    private static void RunLog() {
        long startTime;
        long endTime;
        long runTime;
        System.out.println("Logarithmic algorithm's running times:");

        for (long i = 1000; i < 100000000; i *= 2) {
            startTime = System.nanoTime();
            Algorithms.logarithmicAlgorithm(i);
            endTime = System.nanoTime();
            runTime = endTime - startTime;
            runTime /= 1000000;
            System.out.println("T(" + i + ") = " + runTime);
        }
    }

    private static void RunNlogN() {
        long startTime;
        long endTime;
        long runTime;
        System.out.println("NlogN algorithm's running times:");

        for (long i = 1000; i < 100000000; i *= 2) {
            startTime = System.nanoTime();
            Algorithms.NlogNAlgorithm(i);
            endTime = System.nanoTime();
            runTime = endTime - startTime;
            runTime /= 1000000;
            System.out.println("T(" + i + ") = " + runTime);
        }
    }
         
    private static void RunQuadratic() {
        long startTime;
        long endTime;
        long runTime;
        System.out.println("Quadratic algorithm's running times:");

        for (long i = 1000; i <= 512000; i *= 2) {
            startTime = System.nanoTime();
            Algorithms.quadraticAlgorithm(i);
            endTime = System.nanoTime();
            runTime = endTime - startTime;
            runTime /= 1000000;
            System.out.println("T(" + i + ") = " + runTime);
        }
    }

    private static void RunCubic() {
        long startTime;
        long endTime;
        long runTime;
        System.out.println("Cubic algorithm's running times:");

        for (long i = 1000; i <= 8000; i *= 2) {
            startTime = System.nanoTime();
            Algorithms.cubicAlgorithm(i);
            endTime = System.nanoTime();
            runTime = endTime - startTime;
            runTime /= 1000000;
            System.out.println("T(" + i + ") = " + runTime);
        }
    }
}
