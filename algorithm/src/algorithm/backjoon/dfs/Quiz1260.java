package algorithm.backjoon.dfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;

    public Graph(int size) {
        this.nodes = new Node[size];
        // size만큼 정점 생성
        for (int i = 0; i < size; i++)
            nodes[i] = new Node(i + 1);
    }

    public void addEdge(int num1, int num2) {
        Node node1 = nodes[num1 - 1];
        Node node2 = nodes[num2 - 1];
        node1.adjacent.add(node2);
        node2.adjacent.add(node1);
    }

    // 전위순회
    public void dfs(int start){
        Node node = nodes[start-1];
        if(node.marked==true) return;

        // 마킹해주고 출력
        node.marked=true;
        System.out.print(node.data+" ");
        // 인접한 정점들 출력
        for(Node n : node.adjacent){
            dfs(n.data);
        }
    }

    public void bfs(int start){
        
    }

}

public class Quiz1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        // 정점의 개수
        int N = Integer.parseInt(input[0]);
        // 간선의 개수
        int M = Integer.parseInt(input[1]);
        // 시작할 정점의 번호
        int V = Integer.parseInt(input[2]);

        // 정점을 생성해준다.
        Graph graph = new Graph(N);

        // 정점의 개수만큼 만들어준다.
        for (int i = 0; i < M; i++) {
            String[] nums = br.readLine().split(" ");
            graph.addEdge(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }

        // dfs, bfs
        graph.dfs(V);
        System.out.println();
        graph.bfs(V);

    }
}
