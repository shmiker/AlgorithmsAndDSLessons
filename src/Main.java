
class Main {

    class ArrayList {
        int size;
        int capacity;
        int[] data;

        public ArrayList(int capacity) {
            this.capacity = capacity;
            data = new int[capacity];
            size = 0;
        }

        public void pushBack(int x) {
            data[size] = x;
            size++;

            relocate();
        }

        private void relocate() {
            if (size > capacity) {
                capacity *= 2;
                int[] temp = new int[capacity];
                for (int i = 0; i < size; i++) {
                    temp[i] = data[i];
                }
                data = temp;
            }
        }

        void set(int pos, int x) {
            data[pos] = x;
        }

        void add(int pos, int x) {
            for (int i = size; i > pos; i--) {
                data[i] = data[i - 1];
            }
            data[pos] = x;
            relocate();
        }

        void validate(int pos) {
            if (pos < 0 || pos >= size) {
                throw new ArrayIndexOutOfBoundsException("bad");
            }
        }

        void delete(int pos) {
//            for (int i = pos; i < size-1; i++) {
//                data[i] = data[i + 1];
//            }
            for (int i = 0; i < size - pos; i++) {
                data[pos + i] = data[pos + i + 1];
            }
            size--;
        }

        int get(int pos) {
            return data[pos];
        }
    }

    static class Stack {

        int size = 0;

        public Stack() {
        }

        private class Node {
            Node(int x, Node next) {
                this.x = x;
                this.next = next;
            }

            int x;
            Node next;
        }

        Node head;

        void add(int x) {
            Node node = new Node(x, this.head);
            size++;
            head = node;
        }

        int top() {
            return head.x;
        }

        void pop() {
            head = head.next;
            size--;
        }

        boolean isEmpty() {
            return size == 0;
        }

    }

    static class Queue {
        int size = 0;

        Node head;
        Node tail;

        private class Node {
            int x;
            Node next;

            public Node(int x) {
                this.x = x;
            }
        }

        int front() {
            return head.x;
        }

        void push(int x) {
            Node node = new Node(x);
            if (size == 0) {
                tail = node;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        void pop() {
            head = head.next;
            size--;
        }

        boolean isEmpty() {
            return size == 0;
        }

        static class LinkedList{
            int size = 0;
            Node head;
            Node next;


            class Node{
                int x;
                Node next;
                Node prev;

                public Node(int x, Node prev, Node next) {
                    this.x = x;
                    this.prev = prev;
                    this.next = next;
                }
            }

            int front() {
                return head.x;
            }

            void add(int x){
                if (size == 0){
                    head = new Node(x, null, null);
                    size++;
                }
                if (size == 1){
                    next = new Node(x, head, null);
                    size++;
                }
                if (size > 1){
                    next = new Node(x, next, null);
                    size++;
                }
            }


        }

    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            stack.add(i);
        }


        while (!stack.isEmpty()) {
//            System.out.println(stack.top());
            stack.pop();
        }

        Queue queue = new Queue();
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.front());
            queue.pop();
        }

        LinkedList linkedList = new LinkedList();
        for (int i = 1; i < 10; i++) {
            linkedList.pushBack(i);
            linkedList.pushFront(-i);
            linkedList.print();
            linkedList.printReverse();
        }



    }
}