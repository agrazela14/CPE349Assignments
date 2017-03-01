import java.util.*;
import java.lang.*;

public class DiGraph {
    private LinkedList<Integer>[] graph;

    DiGraph(int n) {
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int from, int to) {
        graph[from - 1].add(to - 1); 
    }

    public void deleteEdge(int from, int to) {
        graph[from - 1].removeFirstOccurrence(to - 1); 
    }

    public int edgeCount() {
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            count += graph[i].size();
        }
        return count;
    }

    public int vertexCount() {
        return graph.length;
    }

    public void print() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print((i + 1) + " is connected to: ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j) + 1);
                if (j != graph[i].size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
