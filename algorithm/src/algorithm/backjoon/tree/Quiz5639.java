package algorithm.backjoon.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 이진 검색트리
// https://www.acmicpc.net/problem/5639
public class Quiz5639 {
    private static Node<Integer> root;
    private static Comparator<Integer> comparator = null;

    static class Node<Integer> {
        private int num;
        private Node<Integer> left;
        private Node<Integer> right;

        public Node(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    } // Node class


    private static int comp(int num1, int num2) {
        return (comparator == null) ? ((Comparable<Integer>) num1).compareTo(num2)
                : comparator.compare(num1, num2);
    }

    public static void add(int num) {
        if (root == null) {
            root = new Node<Integer>(num);
        } else
            addNode(root, num);
    }


    private static void addNode(Node<Integer> node, int num) {
        int cond = comp(num, node.getNum());
        if (cond == 0)
            return;                                        // key가 이진검색트리에 이미 있음
        else if (cond < 0) {
            if (node.left == null)
                node.left = new Node<Integer>(num);
            else
                addNode(node.left, num);            // 왼쪽 서브 트리에 주목
        } else {
            if (node.right == null)
                node.right = new Node<Integer>(num);
            else
                addNode(node.right, num);            // 오른쪽 서브 트리에 주목
        }
    }

    public static void postorder(Node<Integer> n) {
        if (n.left != null)
            postorder(n.left);

        if (n.right != null)
            postorder(n.right);
        System.out.println(n.getNum());
    }


    public static void solution(List<Integer> list) {


        while (!list.isEmpty()) {
            int num = list.get(0);
            list.remove(0);
            Quiz5639.add(num);
        }

        postorder(root);

    }

    public static void main(String args[]) throws IOException {

        Scanner scan = new Scanner(System.in);
        int inputValue;
        List<Integer> list = new ArrayList();

        while (scan.hasNext()) {
            try {
                inputValue = scan.nextInt();
                list.add(inputValue);
            } catch (Exception e) {
                System.out.println("숫자만을 입력해야 합니다. 종료합니다.");
                break;
            }
        }


        solution(list);
    }
}
