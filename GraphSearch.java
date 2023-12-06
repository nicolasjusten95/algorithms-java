import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch {

    ArrayList<Node> nodes;
    int[][] matrix;

    GraphSearch(int size) {
        this.nodes = new ArrayList();
        this.matrix = new int[size][size];
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int i, int j) {
        matrix[i][j] = 1;
    }

    public void removeEdge(int i, int j) {
        matrix[i][j] = 0;
    }

    public boolean checkEdge(int i, int j) {
        return matrix[i][j] == 1;
    }

    public void depthFirstSearch(int src) {
        boolean[] visited = new boolean[matrix.length];
        dFSHelper(src, visited);
        System.out.println();
    }

    private void dFSHelper(int src, boolean[] visited) {
        if (visited[src]) {
            return;
        }
        visited[src] = true;
        System.out.print(nodes.get(src).data + " -> ");
        for (int i = 0; i < matrix[src].length; i++) {
            if (checkEdge(src, i)) {
                dFSHelper(i, visited);
            }
        }
    }

    public void breadthFirstSearch(int src) {
        Queue<Integer> queue = new LinkedList();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            src = queue.poll();
            System.out.print(nodes.get(src).data + " -> ");
            for (int i = 0; i < matrix[src].length; i++) {
                if (checkEdge(src, i) && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public void print() {
        System.out.print("\t");
        for (Node node : nodes) {
            System.out.print(node.data + "\t");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).data + "\t");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        GraphSearch graph = new GraphSearch(5);
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);
        graph.print();
        graph.depthFirstSearch(0);
        graph.breadthFirstSearch(0);
    }

}

class Node {

    char data;

    Node(char data) {
        this.data = data;
    }

}
