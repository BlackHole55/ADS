package Assigment1;

import java.util.Scanner;

public class Task3 { 
    // This method calculates if given number is prime.
    // Time complexity: O(n/2), because algorithm iterates n/2 times.
    private static String isPrime(int n, int i, boolean prime) {
        if (i >= (n / 2) && prime) {
            return "Prime";
        }else if(i >= (n / 2) && !prime) {
            return "Composite";
        }
    
        if ((n % i) == 0) {
            prime = false;
        }
    
        return isPrime(n, i + 1, prime);
    }
    
    public static String isPrime(int n) {
        // i starts from 2 because any n % 1 == 0 would be true
        // and prime is flag
        return isPrime(n, 2, true);
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        int num = sc.nextInt();

        sc.close();
        
        System.out.println(isPrime(num));
    }
}