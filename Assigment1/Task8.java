package Assigment1;

import java.util.Scanner;

public class Task8 {
    // This algorithm detects if string of numbers contains a letter.
    // Time complexity: O(n), because it iterates through all elements from 0 to (n - 1).
    private static String isDigit(char[] strArr, int i, boolean isDigit) {
        if (i >= strArr.length && !isDigit) {
            return "No";
        }else if (i >= strArr.length && isDigit) {
            return "Yes";
        }

        if(!Character.isDigit(strArr[i])) {
            isDigit = false;
        }

        return isDigit(strArr, i + 1, isDigit);
    }

    public static String isDigit(String str) {
        // converts String to array of chars
        char[] strArr = str.toCharArray();

        return isDigit(strArr, 0, true);
    }

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.println("Enter string: ");
        String str = sc.nextLine();

        sc.close();

        System.out.println(isDigit(str));
    }
}
