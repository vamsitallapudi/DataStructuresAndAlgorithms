package main.leetcode.kotlin.trees

class ConstructBinaryTreeFromInorderPostOrder {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.size != postorder.size) return null
        val hashMap = HashMap<Int, Int>()
        for (i in inorder.indices) {
            hashMap[inorder[i]] = i
        }
        return constructBinaryTree(inorder, 0, inorder.size - 1,
                postorder, 0, postorder.size - 1, hashMap)
    }

    private fun constructBinaryTree(inorder: IntArray, inorderStart: Int, inorderEnd: Int, postorder: IntArray, postorderStart: Int, postorderEnd: Int, hashMap: HashMap<Int,Int>): TreeNode? {
        if (inorderEnd < inorderStart || postorderEnd < postorderStart) return null
        val node = TreeNode(postorder[postorderEnd])
        val rootIndex = hashMap[postorder[postorderEnd]]
        val leftChild =  constructBinaryTree(inorder, inorderStart, rootIndex!!-1,
                postorder, postorderStart, postorderStart+rootIndex-inorderStart-1, hashMap )
         val rightChild =  constructBinaryTree(inorder, rootIndex+1, inorderEnd, postorder,
                 postorderStart+rootIndex-inorderStart, postorderEnd-1, hashMap)
        node.left = leftChild
        node.right = rightChild
        return node
    }
}

fun main() {
    printBinaryTree(ConstructBinaryTreeFromInorderPostOrder().buildTree(intArrayOf(4,2,5,1,6,7,3), intArrayOf(4,5,2,6,7,3,1)))
}