import java.util.TreeSet;

public class Set {
    private static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    Node root;
    int size;

    boolean isEmpty() {
        return size == 0;
    }

    private void add(int x, Node node) {
        if (x < node.value) {
            if (node.left == null) {
                node.left = new Node(x, node);
                size++;
            } else {
                add(x, node.left);
            }
        } else if (x > node.value) {
            if (node.right == null) {
                node.right = new Node(x, node);
                size++;
            } else {
                add(x, node.right);
            }
        }

    }

    private void print(Node node) {
        if (node.left != null) {
            print(node.left);
        }
        System.out.print(node.value + " ");
        if (node.right != null) {
            print(node.right);
        }

    }

    public void print() {
        print(this.root);
        System.out.println();
    }


    public void add(int x) {
        if (isEmpty()) {
            this.root = new Node(x);
            size++;
        } else {
            add(x, this.root);
        }
    }

    boolean contains(int x) {
        return size > 0 && contains(x, root);
    }

    boolean contains(int x, Node node) {
        if (x == node.value) {
            return true;
        } else if (x < node.value) {
            return node.left != null && contains(x, node.left);
        } else {
            return node.right != null && contains(x, node.right);
        }
    }

    void remove(int x) {

    }


}
