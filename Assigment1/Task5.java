package Assigment1;

import java.util.Scanner;

public class Task5 {
    public static long fib(int n) {
        if (n == 0 || n == 1) { 
            return n;
        }

        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        int num = sc.nextInt();

        sc.close();

        System.out.println(fib(num));
    }
}
