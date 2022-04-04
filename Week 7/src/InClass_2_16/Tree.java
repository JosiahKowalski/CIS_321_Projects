package InClass_2_16;

import java.util.ArrayDeque;
import java.util.Deque;

public class Tree {
    public static class Node {
        public Node(String cargo){
            this.cargo = cargo;
        }
        public Node left;
        public Node right;
        String cargo;

        @Override
        public String toString() {
            return cargo +
                    (left == null ? "" : "\n"+left) +
                    (right == null ? "" : "\n"+right);
        }

        public static void main(String[] args) {
            Node a = new Node("A");
            Node b = new Node("B");
            Node c = new Node("C");
            Node d = new Node("D");
            Node e = new Node("E");
            Node f = new Node("F");
            Node g = new Node("G");
            a.left = b;
            a.right = c;
            b.left = d;
            b.right = e;
            c.left = f;
            c.right = g;
            System.out.println(a);
//            Queue<Node> queue = new ArrayQueue<>();
        }
    }
}
