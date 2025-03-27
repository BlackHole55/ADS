package Assigment1;

import java.util.Scanner;

public class Task1 {
    // This method finds minimum element of array.
    // The timee compexity: O(n), because algorithm iterates through all elements from 0 to n.
    private static int minElem(int[] arr, int i, int currentMin) {     // currentMin parameter used for storing temporary minimal value

        if (i >= arr.length) {
            return currentMin;
        }
    
        if (currentMin > arr[i]) {
            currentMin = arr[i];
        }
    
        return minElem(arr, i + 1, currentMin);
    }
    
    public static int minElem(int[] arr) {
        return minElem(arr, 0, arr[0]);
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
    
        System.out.println(minElem(arr));
    }
}