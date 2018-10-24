package algorithm.studyGroup.linkedlist;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size=0;

    private class Node{
        private Object data;
        private Node next;
        public Node(Object input){
            this.data = input;
            this.next = null;
        }

        public String toString(){
            return String.valueOf(this.data);
        }
    }
    public void addFirst(Object input){
        //노드를 생성합니다.
        Node newNode=new Node(input);
        //새로운 노드의 다음 노드로 헤드를 지정합니다.
        newNode.next=head;
        // 헤드로 새로운 노드를 지정합니다.
        head = newNode;
        size++;
        if(head.next==null)
            tail=head;
    }

    public void addLast(Object input){
        //노드를 생성합니다.
        Node newNode= new Node(input);
        // 라스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
        if(size == 0){
            addFirst(input);
        } else{
            //마지막 노드의 다음 노드로 생성한 노드를 지정합니다.
            tail.next = newNode;
            // 마지막 노드를 갱신합니다.
            tail = newNode;
            // 엘리먼트의 개수를 1증가 시킵니다.
            size++;
        }
    }

    Node node(int index){
        Node x = head;
        for(int i=0;i<index;i++)
            x=x.next;
        return x;
    }

    public void add(int k, Object input ){
        // 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용합니다.

        if(k==0)
            addFirst(input);
        else{
            Node temp1 = node(k-1);
            // k번째 노드를 temp2로 지정.
            Node temp2 = temp1.next;
            //새로운 노드를 생성합니다.
            Node newNode = new Node(input);
            // temp1의 다음 노드로 새로운 노드를 지정
            temp1.next=newNode;
            // 새로운 노드의 다음 노드로 temp2를 지정.
            newNode.next=temp2;
            size++;
            // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정
            if(newNode.next == null){
                tail=newNode;
            }
        }
    }
}
