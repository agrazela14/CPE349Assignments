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
        str = sc.nextLine();
        graph = new DiGraph(n);

        System.out.println("Choose one of the following operations:");
        System.out.println("-add edge (enter a)");
        System.out.println("-delete edge (enter d)");
        System.out.println("-edge count (enter e)");
        System.out.println("-vertex count (enter v)");
        System.out.println("-print graph (enter p)");
        System.out.println("-topological sort (enter t)");
        System.out.println("-is there a path (enter i)");
        System.out.println("-length of path (enter l)");
        System.out.println("-show path (enter s)");
        System.out.println("-print breadth-first-tree (enter b)");
        System.out.println("-Quit (enter q)");
        
        str = sc.nextLine();

        if (str.length() > 1) {
            cmd = 'x'; //Invalid if the input was more than 1 character
        }
        else {
            cmd = str.charAt(0);
        }

        while (cmd != 'q') {
            switch (cmd) {
                case 'a':
                    System.out.println("Enter from what vertex to what vertex");
                    from = sc.nextInt();
                    to = sc.nextInt();
                    sc.nextLine();

                    graph.addEdge(from, to);
                    System.out.println("(" + from + ", " + to + ") edge is now added to the graph");
                    break;

                case 'd':
                    System.out.println("Enter from what vertex to what vertex");
                    from = sc.nextInt();
                    to = sc.nextInt();
                    sc.nextLine();

                    graph.deleteEdge(from, to);
                    System.out.println("(" + from + ", " + to + ") edge is now removed from the graph");
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
                        System.out.println();
                    }
                    catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 'i':
                    System.out.println("Enter from what vertex to what vertex");
                    from = sc.nextInt();
                    to = sc.nextInt();
                    sc.nextLine();

                    if (graph.isTherePath(from - 1, to - 1)) {
                        System.out.println("Yes, there is a path between " + from + " and " + to);
                    }
                    else {
                        System.out.println("There is no path between " + from + " and " + to);
                    }

                    break;

                case 'l':
                    System.out.println("Enter from what vertex to what vertex");
                    from = sc.nextInt();
                    to = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Length of path between " 
                     + from + " and " + to + " is " + graph.lengthOfPath(from - 1, to - 1));
                    break;

                case 's':
                    System.out.println("Enter from what vertex to what vertex");
                    from = sc.nextInt();
                    to = sc.nextInt();
                    sc.nextLine();

                    graph.printPath(from - 1, to - 1);
                    break;

                case 'b':
                    System.out.println("Enter root vertex");
                    from = sc.nextInt();
                    sc.nextLine();
                    graph.printTree(from - 1);

                    break;

                case 'q':
                    break;

                default:
                    System.out.println("That's an invalid command, please try again, lowercase only");
                    break;
            }
            /*
            while (!(sc.hasNextLine())) {
            }
            */

            str = sc.nextLine();
            //cmd = (sc.next().charAt(0));
            if (str.length() > 1) {
                cmd = 'x'; //Invalid if the input was more than 1 character
            }
            else {
                cmd = str.charAt(0);
            }
        }
        System.out.println("Thanks for playing, goodbye!");
        sc.close();
    }
}
