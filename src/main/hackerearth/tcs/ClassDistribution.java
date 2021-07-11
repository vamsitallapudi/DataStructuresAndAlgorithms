package main.hackerearth.tcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ClassDistribution {
    static String ans = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim()); // no. of test cases
        for (int i = 0; i < T; i++) {
            ans = "";
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            String[] capacityStr = br.readLine().split(" ");
            int[] capacity = new int[K];
            for (int j = 0; j < capacity.length; j++) {
                capacity[j] = Integer.parseInt(capacityStr[j]);
            }
            String[] preference = new String[N];
            for (int j = 0; j < preference.length; j++) {
                preference[j] = br.readLine();
            }
            String output = solve(N, K, capacity, preference);
            System.out.println(output);

        }
        wr.close();
        br.close();
    }

    static String solve(int N, int K, int[] capacity, String[] preference) {
        int totalCapacity = 0;
        for (int i = 0; i < capacity.length; i++) {
            totalCapacity += capacity[i];
        }
        // Edge Case
        if (totalCapacity < N) {
            return "NO";
        }


        List<Boolean> visited = new ArrayList<>();
        performDFS(N, 0,capacity,  visited, preference);
        if(ans.equalsIgnoreCase("")) ans = "NO";
        return ans;
    }

    static void performDFS(int N, int stud, int[] capacity, List<Boolean> visited, String[] preference) {
        if(ans.equals("YES") || !checkIfCapacityMatches(capacity)) {
            return;
        }
        if (stud == N) {
            if (checkIfCapacityMatches(capacity)) {
                ans = "YES";
            }
            return;
        }
        String[] pref = preference[stud].split(",");
//        Firstly, setting that this student is visited.
        visited.add(stud, true);

        for (String p : pref) {
            int studPref = Integer.parseInt(p);
            int[] newCap = capacity.clone();
            newCap[--studPref]--;
            performDFS(N,stud + 1, newCap, visited, preference);
        }
    }

    private static boolean checkIfCapacityMatches(int[] capacity) {
        for (int cap : capacity) {
            if (cap < 0) return false;
        }
        return true;
    }

}
