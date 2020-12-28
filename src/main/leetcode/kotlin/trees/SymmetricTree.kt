package main.leetcode.kotlin.trees

import java.util.*

class SymmetricTree {
    fun isSymmetricRecursive(root: TreeNode?): Boolean {
        return root == null || areSymmetric(root.left, root.right)
    }

    private fun areSymmetric(left: TreeNode?, right:TreeNode?): Boolean {
        if (left == null || right == null) {
            return left == right
        }
        if(left.data != right.data) {
            return false
        }
        return areSymmetric(left.left,right.right) && areSymmetric(left.right, right.left)
    }

    fun isSymmetricIterative(root:TreeNode?): Boolean {
        if (root == null) return true
//        because stack can hold null, we are using stack here
        val stack = Stack<TreeNode>()
        stack.push(root.left)
        stack.push(root.right)
        while(stack.isNotEmpty()) {
            val p = stack.pop()
            val q = stack.pop()
            if (p == null && q == null) continue
            if (p == null || q == null || p.data != q.data) return false
            stack.push(p.left)
            stack.push(q.right)
            stack.push(p.right)
            stack.push(q.left)
        }
        return true
    }
}

fun main() {
    print(SymmetricTree().isSymmetricRecursive(initializeBinaryTree()))
    print(SymmetricTree().isSymmetricIterative(initializeBinaryTree()))
}