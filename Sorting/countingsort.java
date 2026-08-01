package Sorting:

public class CountingSort {

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        int max = arr[0];
        for(int num : arr) {
            if(num > max) max = num;

        }
        int[] count = new int[max + 1];
        int[] output = new int[arr.length];

        //Counting frequency of elements
        for(int num : arr) {
            count[num]++;
        }

        //Number of elements less than equal to index i 
        for(int i = 1; i <= max; i++) {
            count[i] += count[i -1];
        }

        //Placing of numbers on the right index values
        for(int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            output[count[num] -1] = num;
            count[num]--;
        }

        //Copy output back to original array
        System.arraycopy(output, 0, arr, 0, arr.length)

    }

    public static void main(String[] args) {
        int[] arr = {4,2,2,8,3,3,1};
        System.out.println("Original Array :");
        for(int n : arr) System.out.print(n + " ");

        countingSort(arr);

        System.out.println("\nSorted Array");
        for (int n : arr) System.out.print(n + " ");
    }
}