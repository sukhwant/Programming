package mission.red.geeksforgeeks.datastructure.queue;

import javatutorial.datastructure.tree.BinarySearchTree;

/**
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 * 
 * @author sukhwanp
 *
 */

public class LevelOrderTraversal {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(2);
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);

        bst.levelOrderTraversal().stream().forEach(System.out::println);
    }

}
