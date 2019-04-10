package algorithm.leetcode.dfs;

import java.util.List;

public class LeetCode559 {
    int maxDepth = 0;

    public int maxDepth(Node root) {
        if (root == null) return 0;
        dfs(root, 1);
        return maxDepth;
    }

    public void dfs(Node node, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        for (Node n : node.children)
            dfs(n, depth + 1);
    }

    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};