package main.leetcode.kotlin

import java.util.*

class StockSpanner {
    val stack = Stack<IntArray>()
    fun next(price: Int): Int {
        var span = 1
        while (!stack.isEmpty() && price > stack.peek()[0]) {
            span+= stack.peek()[1]
            stack.pop()
        }
        stack.push(intArrayOf(price, span))
        return span
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = StockSpanner()
 * var param_1 = obj.next(price)
 */