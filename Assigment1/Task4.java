package Assigment1;

import java.util.Scanner;

public class Task4 {
    // This method calculates the factorial of a given number.
    // Time complexity: O(n), because algorithm iterates through all elements from 1 to n.
    private static int factorial(int n, int i, int result) {
        if (i > n) {
            return result;
        }
    
        result *= i;
    
        return factorial(n, i + 1, result);
    }
    
    public static int factorial(int n) {
        return factorial(n, 1, 1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        int num = sc.nextInt();

        sc.close();

        System.out.println(factorial(num));
    }
}