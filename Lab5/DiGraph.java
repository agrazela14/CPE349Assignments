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
        if (!(graph[from - 1].contains(to - 1))) {
            graph[from - 1].add(to - 1); 
        }
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
    
    private int[] indegrees() {
        int[] indegreeArray = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                indegreeArray[graph[i].get(j)]++;
            }
        }
        return indegreeArray;
    }

    public int[] topSort() {
        LinkedList<Integer> Q = new LinkedList<Integer>();
        int[] indegreeArray = this.indegrees();
        int[] sorted = new int[graph.length];
        int current, sortedCount = 0;

        for (int i = 0; i < indegreeArray.length; i++) {
            if (indegreeArray[i] == 0) {
                Q.add(i);
            }
        }
        
        while (Q.size() != 0) {
            current = Q.remove();
            for (int i = 0; i < graph[current].size(); i++) {
                indegreeArray[graph[current].get(i)]--;
                if (indegreeArray[graph[current].get(i)] == 0) {
                    Q.add(graph[current].get(i));
                }
            }
            sorted[sortedCount] = current;
            sortedCount++;
        }

        if (sortedCount != graph.length) {
            throw new IllegalArgumentException("There is a cycle");
        }
        return sorted;
    }
}
