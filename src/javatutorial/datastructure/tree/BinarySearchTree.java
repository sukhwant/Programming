package javatutorial.datastructure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node head = null;

    private class Node {
        T data;
        Node left, right;
        Node parent;

        private Node(T data) {
            this.data = data;
            this.left = this.right = this.parent = null;
        }
    }

    public T search(T key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data.equals(key)) {
                return temp.data;
            } else if (temp.data.compareTo(key) > 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        return null;
    }

    public void insert(T data) {
        Node temp = head;
        Node parent = null;

        Node node = new Node(data);
        while (temp != null) {
            parent = temp;
            if (temp.data.compareTo(data) > 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        node.parent = parent;

        if (head == null) {
            head = node;
        } else if (parent.data.compareTo(data) > 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }

    public List<T> preOrderTraversal() {
        List<T> answer = new LinkedList<>();
        preOrder(head, answer);
        return answer;
    }

    private void preOrder(Node node, List<T> answer) {
        if (node != null) {
            answer.add(node.data);
            preOrder(node.left, answer);
            preOrder(node.right, answer);
        }
    }

    public List<T> postOrderTraversal() {
        List<T> answer = new LinkedList<>();
        postOrder(head, answer);
        return answer;
    }

    private void postOrder(Node node, List<T> answer) {
        if (node != null) {
            postOrder(node.left, answer);
            postOrder(node.right, answer);
            answer.add(node.data);
        }
    }

    public List<T> inOrderTraversal() {
        List<T> answer = new LinkedList<>();
        inOrder(head, answer);
        return answer;
    }

    private void inOrder(Node node, List<T> answer) {
        if (node != null) {
            inOrder(node.left, answer);
            answer.add(node.data);
            inOrder(node.right, answer);
        }
    }

    public List<T> levelOrderTraversal() {
        List<T> answer = new LinkedList<>();
        levelOrder(head, answer);
        return answer;
    }

    private void levelOrder(Node node, List<T> answer) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp != null) {
                queue.add(temp.left);
                queue.add(temp.right);

                answer.add(temp.data);
            }
        }
    }

    public void delete(T key) {

    }
}
