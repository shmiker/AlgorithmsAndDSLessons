public class LinkedList {

    int size = 0;

    class Node {
        int x;
        Node prev;
        Node next;

        public Node(int x, Node prev, Node next) {
            this.x = x;
            this.prev = prev;
            this.next = next;
        }

        public Node(int x) {
            this.x = x;
        }

        public Node(int x, Node prev) {
            this.x = x;
            this.prev = prev;
        }

        public Node(Node next, int x) {
            this.x = x;
            this.next = next;
        }

    }

    Node first;
    Node last;

    void pushBack(int x) {
        if (size == 0) {
            Node node = new Node(x);
            first = last = node;
        } else {
            Node node = new Node(x, last);
            last.next = node;
            last = node;
        }
        size++;
    }

    void pushFront(int x) {
        if (size == 0) {
            Node node = new Node(x);
            first = last = node;
        } else {
            Node node = new Node(first, x);
            first.prev = node;
            first = node;
        }
    }

    void print() {
        for (Node node = first; node != null; node = node.next) {
            System.out.print(node.x + " ");
        }
        System.out.println();
    }

    void printReverse() {
        for (Node node = last; node != null; node = node.prev) {
            System.out.print(node.x + " ");
        }
        System.out.println();
    }

    void set(int x, int pos) {
        Node node = first;
        for (int count = 0; count != pos; count++) {
            node = node.next;
        }
        node.x = x;

        // дописать оптимизанию если pos > size / 2
    }

    void add(int x, int pos) {
        if (pos == 0) {
            pushFront(x);
            size++;
        } else if (pos == size) {
            pushBack(x);
            size++;
        } else {
            Node next = getNode(pos);
            // дописать оптимизанию если pos > size / 2
            Node prev = next.prev;
            Node node = new Node(x, prev, next);
            prev.next = node;
            next.prev = node;
            size++;
        }
    }

    Node getNode(int pos) {
        Node node = first;
        for (int count = 0; count != pos; count++) {
            node = node.next;
        }
        return node;
    }


    void popBack(){
        if (size == 1){
            last = first = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    void popFront(){
        if (size == 1){
            last = first = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
    }

    void remove(int pos){
        if (pos == 0){
            popFront();
        } else if (pos == size-1){
            popBack();
        } else {
            Node node = getNode(pos);
            node.prev = node.next;
            node.next = node.prev;
            size--;
        }
    }

    //Node{value=1, prev=null, next = 2}, Node{value=4, prev=4, next=1}..., Node{value=9, prev=3, next=null}
    //fisrt = 0
    //last = 5
    // values:    1 4 7 3 8 9 2
    // addresses: 4 2 1 8 3 5 7

}
