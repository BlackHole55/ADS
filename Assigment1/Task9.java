package Assigment1;

import java.util.Scanner;

public class Task9 {
    // This algorithm calculates binomial coefficient
    // Time complexity: O(n), beccause in worst case it iterates from k to 0.
    public static int binomial(int k, int n) {
        if (k > n) {
            System.out.println("k can not be greater than n");
            return 0;
        }

        if (k == 0 || k == n) {
            return 1;
        }

        return binomial(k - 1, n - 1) + binomial(k, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();
        
        System.out.println("Enter k: ");
        int k = sc.nextInt();

        sc.close();

        System.out.println(binomial(k, n));
    } 
}
