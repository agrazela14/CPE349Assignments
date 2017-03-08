import java.util.*;
import java.lang.*;

public class DiGraphTest {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        DiGraph graph;
        int n, from, to;
        char cmd;
        String str;

        System.out.println("Enter a number of verticies");
        n = sc.nextInt();
        graph = new DiGraph(n);

        System.out.println("Choose one of the following operations:");
        System.out.println("-add edge (enter a)");
        System.out.println("-delete edge (enter d)");
        System.out.println("-edge count (enter e)");
        System.out.println("-vertex count (enter v)");
        System.out.println("-print graph (enter p)");
        System.out.println("-topological sort (enter t)");
        System.out.println("-Quit (enter q)");

        cmd = (sc.next().charAt(0));
        //cmd = str.charAt(0);

        while (cmd != 'q') {
            switch (cmd) {
                case 'a':
                    System.out.println("Enter from what vertex to what vertex");
                    from = sc.nextInt();
                    to = sc.nextInt();

                    graph.addEdge(from, to);
                    System.out.println("Done");
                    break;

                case 'd':
                    System.out.println("Enter from what vertex to what vertex");
                    from = sc.nextInt();
                    to = sc.nextInt();

                    graph.deleteEdge(from, to);
                    System.out.println("Done");
                    break;

                case 'e':
                    System.out.println("There are this many edges:");
                    System.out.println(graph.edgeCount());
                    break;

                case 'v':
                    System.out.println("There are this many verticies:");
                    System.out.println(graph.vertexCount());
                    break;

                case 'p':
                    System.out.println("The graph looks like this:");
                    graph.print();
                    break;

                case 't':
                    int[] sorted;
                    System.out.print("Topologically sorted vertices: ");
                    try {
                        sorted = graph.topSort();
                        for(int i = 0; i < sorted.length; i++) {
                            System.out.print(sorted[i] + 1);
                            if (i != sorted.length - 1) {
                                System.out.print(", ");
                            }
                        }
                    }
                    catch (IllegalOperationException e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 'q':
                    break;

                default:
                    System.out.println("That's an invalid command, please try again, lowercase only");
                    break;
            }
            cmd = (sc.next().charAt(0));
        }
        System.out.println("Thanks for playing, goodbye!");
        sc.close();
    }
}