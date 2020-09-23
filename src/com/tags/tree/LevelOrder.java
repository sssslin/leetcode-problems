package com.tags.tree;

import java.util.*;

/**
 * 做树这个类型的题目，应该用栈，或者队列这两种数据结构比较合适，而不是数组
 */
public class LevelOrder {

    public static void main(String[] args) {

        Object array[] = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode((int) array[1]);
        treeNode.right = new TreeNode((int) array[2]);

        treeNode.right.left = new TreeNode((int) array[5]);
        treeNode.right.right = new TreeNode((int) array[6]);

        List<List<Integer>> results = levelOrder(treeNode);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(Arrays.toString(results.get(i).toArray()));
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        //1、先构建了一个双层列表，用于存储结果
        List<List<Integer>> result = new ArrayList<>();
        //2、再创建一个队列，用于存储每一层的节点，然后再pop
        Queue<TreeNode> queue = new LinkedList<>();

        //3、判断二叉树不为空的操作
        if (root != null) {
            queue.add(root);
        }

        //在队列非空时处理
        while (!queue.isEmpty()) {
            //4、创建一个单层列表，用来存储每一层的结果
            List<Integer> middle = new ArrayList<>();

            //5、开始遍历队列输出
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                middle.add(node.val);

                //6、判断节点的左右子节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(middle);
        }
        return result;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
