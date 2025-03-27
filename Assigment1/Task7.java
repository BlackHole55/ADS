package Assigment1;

import java.util.Scanner;

public class Task7 {
    // This algorithm is reverses order of elements in array.
    // Time complexity: O(n), because algorithm iterates through all elements from (n - 1) to 0.
    private static int reverse(int[] arr, int i) {
        if (i < 0) {
            return 0;
        }
    
        System.out.print(arr[i] + " ");
    
        return reverse(arr, i - 1);
    }
    
    public static int reverse(int[] arr) {
        return reverse(arr, arr.length - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array length: ");
        int arrayLength = sc.nextInt();
        int[] arr = new int[arrayLength];
        System.out.println("Enter array elements:");

        for(int i = 0; i < arrayLength; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
    
        reverse(arr);
    }
}
