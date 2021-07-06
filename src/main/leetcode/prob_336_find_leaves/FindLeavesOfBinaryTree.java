package main.leetcode.prob_336_find_leaves;
import javafx.util.Pair;

import java.util.*;

public class FindLeavesOfBinaryTree {

    List<Pair<Integer, Integer>> pairs;

    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {

        // Using DFS with Height Sorting

        pairs = new ArrayList<>();
        getHeight(root);

        Collections.sort(pairs, Comparator.comparing(it -> it.getKey()));
        List<List<Integer>> sol = new ArrayList<>();

        int n = pairs.size(), height = 0, i = 0;

        while (i < n) {
            List<Integer> currHeightItems = new ArrayList<>();
            while (i < n && pairs.get(i).getKey() == height) {
                currHeightItems.add(pairs.get(i).getValue());
                i++;
            }
            sol.add(currHeightItems);
            height++;
        }
        return sol;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int currHeight = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        pairs.add(new Pair<>(currHeight, node.value));
        return currHeight;
    }
}
