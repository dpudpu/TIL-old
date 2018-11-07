package algorithm.backjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Quiz1991 {
    private static Node<String> root;

    static class Node<String> {
        private String alphabet;
        private Node<String> left;
        private Node<String> right;

        public Node(String alphabet) {
            this.alphabet = alphabet;
        }

        public String getAlphabet() {
            return alphabet;
        }
    } // Node class

    public static Node<String> add(String alphabet) {
        if (root == null) {
            root = new Node<String>(alphabet);
            return root;
        } else
            return new Node<String>(alphabet);
    }


    public static void preorder(Node<String> n) { // 처음엔 헤드가 들어온다.
        System.out.print(n.getAlphabet());

        if (n.left != null)
            preorder(n.left);

        if (n.right != null)
            preorder(n.right);

    }

    public static void inorder(Node<String> n) {
        if (n.left != null)
            inorder(n.left);

        System.out.print(n.getAlphabet());

        if (n.right != null)
            inorder(n.right);
    }

    public static void postorder(Node<String> n) {
        if (n.left != null)
            postorder(n.left);

        if (n.right != null)
            postorder(n.right);
        System.out.print(n.getAlphabet());
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> check = new ArrayList<Node>();

        for (int i = 0; i < N; i++) {
            Node<String> parent = null;
            Node<String> left = null;
            Node<String> right = null;

            String[] str = br.readLine().split(" ");

            for (Node n : check) {
                if (n.getAlphabet().equals(str[0])) {
                    parent = n;
                    break;
                }
            }
            if (parent == null) {
                parent = Quiz1991.add(str[0]);
                check.add(parent);
            }
            if (!str[1].equals(".")) {
                left = Quiz1991.add(str[1]);
                check.add(left);
            }
            if (!str[2].equals(".")) {
                right = Quiz1991.add(str[2]);
                check.add(right);
            }

            parent.left = left;
            parent.right = right;

        }
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);

    }
}

