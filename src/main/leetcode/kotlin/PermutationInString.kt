package main.leetcode.kotlin

fun main() {
    if(PermutationInString().checkInclusion("ab", "eidbaooo")) print("True") else print("False")
}
class PermutationInString {
    fun checkInclusion(s1:String, s2: String): Boolean {
        val len1 = s1.length
        val len2 = s2.length
        val value = Array(26) {0}
        if (len2 < len1) return false

        for (i in 0 until len1) {
//            filling value array with the frequencies of string 1
            value[s1[i] - 'a']++
        }
        for (i in 0 until len2) {
            /* Using window technique. Array position which enters into window will be subtracted with 1
            and the array position goes into window will be added with 1.
            *
            * */
            value[s2[i] - 'a']--
//            checking if the position is out of window and we are reverting the subtraction by adding 1
            if (i- len1 >=0) value[s2[i - len1] - 'a']++
            if (isAllZeroes(value)) return true
        }
        return false
    }


    private fun isAllZeroes(arr:Array<Int>) : Boolean {
        for (i in arr) {
            if (i != 0) return false
        }
        return true
    }
}