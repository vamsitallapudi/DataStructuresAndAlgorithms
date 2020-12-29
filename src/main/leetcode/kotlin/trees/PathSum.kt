package main.leetcode.kotlin.trees
//Given a binary tree and a sum,
// determine if the tree has a root-to-leaf path such that
// adding up all the values along the path equals the given sum.
class PathSum {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null) return sum == root.data
        return hasPathSum(root.left, sum-root.data) || hasPathSum(root.right, sum-root.data)
    }
}

fun main() {
    print(PathSum().hasPathSum(initializeBinaryTree(), 4))
}