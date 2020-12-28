package main.leetcode.kotlin.trees

import main.leetcode.kotlin.trees.TreeNode
import main.leetcode.kotlin.trees.initializeBinaryTree


class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + maxDepth(root.left).coerceAtLeast(maxDepth(root.right))
    }
}

fun main() {
    print(MaximumDepthOfBinaryTree().maxDepth(initializeBinaryTree()))
}