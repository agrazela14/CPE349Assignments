import java.util.*;
import java.lang.*;

public class DiGraph {
    private LinkedList<Integer>[] graph;

    DiGraph(int n) {
        graph = new LinkedList[n];
    }

    public void addEdge(int from, int to) {
        graph[from].add(to); 
    }

    public void deleteEdge(int from, int to) {
        graph[from].remove(to); 
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
            System.out.print(i + " is connected to: ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(j);
                if (j != graph[i].size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
