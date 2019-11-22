package study.binarytree;

import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/9
 */
public class BinaryTreeTest {

    @Test
    public void binaryTreeTest() {
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.insert(33);
        binaryTree.insert(17);
        binaryTree.insert(50);
        binaryTree.insert(13);
        binaryTree.insert(18);
        binaryTree.insert(34);
        binaryTree.insert(58);
        binaryTree.insert(16);
        binaryTree.insert(25);
        binaryTree.insert(51);
        binaryTree.insert(66);
        binaryTree.insert(19);
        binaryTree.insert(27);
        binaryTree.insert(55);
        System.out.println(binaryTree);

        System.out.println("先序遍历");
        binaryTree.preOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println("中序遍历");
        binaryTree.midOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println("后序遍历");
        binaryTree.postOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println("分层遍历");
        binaryTree.levelOrder(binaryTree.getRoot());
        System.out.println();

        System.out.println("获取树的高度：");
        System.out.println(binaryTree.getTreeHeight(binaryTree.getRoot()));

        System.out.println();
        System.out.println("查找：");
        System.out.println(binaryTree.search(19));

        System.out.println("删除：");
        System.out.println(binaryTree.remove(50));
        binaryTree.midOrder(binaryTree.getRoot());

    }
}
