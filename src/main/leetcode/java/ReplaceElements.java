package main.leetcode.java;

import java.util.Arrays;

public class ReplaceElements {
    public int[] replaceElements(int[] arr) {
        for (int i = arr.length - 1, mx = -1; i >= 0; i--)
            mx = Math.max(arr[i], arr[i] = mx);
        return arr;
    }

    public static void main(String[] args) {
        ReplaceElements rep = new ReplaceElements();
        int[] arr = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(rep.replaceElements(arr)));
    }
}
