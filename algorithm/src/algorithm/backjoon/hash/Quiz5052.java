package algorithm.backjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Quiz5052 {


    public static void check(ChainHash chainHash, String nums[]) {
        boolean check = false;

        for(String s : nums) {
            check = chainHash.search(s);
            if(check==true) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 숫자 개수
            int n = Integer.parseInt(br.readLine());
            ChainHash chainHash = new ChainHash();

            String[] nums = new String[n];
            for (int k = 0; k < n; k++) {
                nums[k] = br.readLine();
            }
            for(String s: nums)
                chainHash.add(s);
            check(chainHash, nums);
        }
    }
}

class ChainHash {
    private Node[] table;

    class Node {
        private String number;
        private Node next;

        public Node(String number,Node next) {
            this.number = number;
            this.next = next;
        }

        public String getnumber() {
            return number;
        }

        @Override
        public int hashCode() {
            return number.charAt(0)-'0';
        }
    }

    public ChainHash() {
        table = new Node[10];
    }

    public boolean search(String number){
        // 아스키코드 때문에 -'0'
        int hash = number.charAt(0)-'0';
        Node p = table[hash];
        while (p!=null){
            if(number.length()!=p.getnumber().length() && p.getnumber().startsWith(number)){
                return true;
            }
            p=p.next;
        }
        return false;
    }

    public void add(String number) {
        int hash = number.charAt(0)-'0';
        Node p = table[hash];
        while (p != null) {
            if (p.getnumber().equals(number))        // 이 키 값은 이미 등록됨
                return;
            p = p.next;                        // 다음 노드에 주목
        }
        Node temp = new Node(number, table[hash]);
        table[hash] = temp;                    // 노드를 삽입
        return;
    }
}