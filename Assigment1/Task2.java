package Assigment1;

import java.util.Scanner;

public class Task2 {
    // This method calculates total sum of all elements of array.
    // The timee compexity: O(n), because algorithm iterates through all elements from 0 to n.
    private static float sum(int[] arr, int i, float sum) {
        if (i >= arr.length) {
            return sum;
        }
    
        sum += arr[i];
    
        return sum(arr, i + 1, sum);
    }
    
    public static float averageNum(int[] arr) {
        float sum = sum(arr, 0, 0);
        float average = sum / arr.length;

        return average;
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
    
        System.out.println(averageNum(arr));
    }
}