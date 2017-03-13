import java.util.*;
import java.lang.*;

public class DiGraph {

    private class TreeNode {
        private int vertNumber;
        private LinkedList<TreeNode> children;

        public TreeNode(int num) {
            this.vertNumber = num;
            this.children = new LinkedList<TreeNode>();
        }

        public void addChild(TreeNode child) {
            this.children.add(child);
        }

        public LinkedList<TreeNode> getChildren() {
            return this.children;
        }

        public void setvertNumber(int num) {
            this.vertNumber = num;
        }

        public int getvertNumber() {
            return this.vertNumber;
        }
    }

    private class VertexInfo {
        private int dist;
        private int parent;

        public VertexInfo(int dist, int parent) {
            this.dist = dist;
            this.parent = parent;
        }

        public int getDist() {
            return this.dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public int getParent() {
            return this.parent;
        }

        public void setParent(int par) {
            this.parent = par;
        }

    }

    private LinkedList<Integer>[] graph;

    DiGraph(int n) {
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<Integer>();
        }
    }

    private VertexInfo[] BFS(int s) {
        VertexInfo verts[] = new VertexInfo[graph.length];
        int cur;
        
        for (int u = 0; u < graph.length; u++) {
            verts[u] = new VertexInfo(-1, -1);
        }
        verts[s] = new VertexInfo(0, -1); 

        LinkedList<Integer> q = new LinkedList<Integer>();
        
        q.add(s);

        while(q.size() > 0) {
            cur = q.removeFirst();
            for (int node : graph[cur]) {
                if (verts[node].getDist() == -1) {
                    verts[node].setDist(verts[cur].getDist() + 1);
                    verts[node].setParent(cur);
                    q.add(node);
                }
            }
        }
        return verts;
    }

    public boolean isTherePath(int from, int to) {
       VertexInfo[] verts = BFS(from);
       return(verts[to].getDist() > 0);
    }

    public int lengthOfPath(int from, int to) {
       VertexInfo[] verts = BFS(from);
       return verts[to].getDist();
    }

    public void printPath(int from, int to) {
       VertexInfo[] verts = BFS(from);
       int arr[];
       int cur = to;
       if (verts[to].getDist() > 0) {
          arr = new int[verts[to].getDist() + 1];
          for (int i = 0; i < arr.length; i++) {
              arr[i] = cur;
              cur = verts[cur].getParent(); 
          }
          for (int i = arr.length - 1; i >= 0; i--) {
              System.out.print(arr[i] + 1);
              if (i != 0) {
                  System.out.print(" -> ");
              }
          }
          System.out.println();
       }
       else {
           System.out.println("There is no path between " + from + " and " + to);
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

    private TreeNode buildTree(int s) {
        VertexInfo[] vertInf = BFS(s);

        TreeNode[] nodes = new TreeNode[graph.length];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i);
        }

        for (int i = 0; i < vertInf.length; i++) {
            if (vertInf[i].getParent() >= 0) {
                nodes[vertInf[i].getParent()].addChild(nodes[i]);
            }
        }

        return nodes[s];
    }

    public void printTree(int s) {
        TreeNode root = buildTree(s);
        printTree(root, ""); 
    }

    private void printTree(TreeNode node, String indents) {
        System.out.print(indents);
        System.out.println(node.getvertNumber() + 1);
        for (TreeNode child : node.getChildren()) {
            printTree(child, indents + "    ");
        }
    }
}
