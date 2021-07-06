package main.hackerearth.hsbc

import java.util.*

fun main() {
    val times = readLine()!!.toInt()
    for (i in 0 until times) {
        val count = readLine()!!.toLong()
        val values = readLine()!!.split(" ").map{it.toLong()}.toList()
        val finalList = stackDisplay(count,values)
        println(finalList.joinToString(separator=" "))
    }
}
fun stackDisplay(N:Long, arr:List<Long>) : List<Long> {
    var finalList = mutableListOf<Long>()
    if(N <= 0L || arr.isNullOrEmpty())
        return finalList
    val stack = Stack<Long>()
    for (i in arr) {
        if (i==0L) {
            if(stack.isEmpty()) {
                finalList.add(0L)
                continue
            } else {
                stack.pop()
            }
        } else {
            stack.push(i)
        }
        finalList.add(performCalc(stack))
    }
    return finalList
}

fun performCalc(stack: Stack<Long>) : Long {
    var sum = 0L
    var singlesSum = 0L
// the expression is equal to sum of squares of all numbers multiplied by sum of all numbers
    stack.forEach {singlesSum += it}
    if(singlesSum == 0L)
        return 0L
    stack.forEach { sum+=(it * it)}

    return sum * singlesSum

}

