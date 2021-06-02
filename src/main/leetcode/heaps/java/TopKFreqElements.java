package main.leetcode.heaps.java;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] sol = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new SortByFreq());
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        for (int i = k-1; i>=0; i--) {
            sol[i] = minHeap.poll().getKey();
        }
        return sol;
    }
}

class SortByFreq implements Comparator<Map.Entry<Integer, Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue() - o2.getValue();
    }
}


public class TopKFreqElements {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = s.topKFrequent(new int[] {1,1,1,2,3,3,4}, 2 );
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
