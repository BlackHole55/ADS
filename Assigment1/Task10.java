package Assigment1;

import java.util.Scanner;

public class Task10 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, Math.abs(a - b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a: ");
        int a = sc.nextInt();
        
        System.out.println("Enter b: ");
        int b = sc.nextInt();

        sc.close();

        System.out.println(gcd(a, b));
    } 
}
