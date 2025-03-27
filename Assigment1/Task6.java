package Assigment1;

import java.util.Scanner;

public class Task6 {
    // This algorithm calculates power of given number.
    // Time complexity: O(n), because algorithm iterates through all elements from 0 to powNum.
    private static long pow(int base, int powNum, int i, long result) {
        if (i >= powNum) {
            return result;
        }

        return pow(base, powNum, i + 1, result * base);
    }

    public static long pow(int base, int powNum) {
        return pow(base, powNum, 0, 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        int num = sc.nextInt();

        System.out.println("Enter power: ");
        int power = sc.nextInt();

        sc.close();

        System.out.println(pow(num, power));
    }
}
