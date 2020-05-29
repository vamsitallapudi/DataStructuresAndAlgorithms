package main.ctci.arrays;

import java.util.Scanner;

public class IsUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isUniqueChars(sc.next()));
    }
    static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i=0; i<str.length();i++) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1<<val);
        }
        return true;
    }
}
