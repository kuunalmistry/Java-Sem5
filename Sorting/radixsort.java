package Sorting;

public class RadixSort {
    public static void radixSort(int[] arr){
        int max = arr[0];
        for (int val : arr){
            if (val > max){
                max = val;
            }
        }
        for (int exp = 1; max / exp > 0; exp *= 10){
            countingSort(arr, exp);
        }
    }
    private static void countingSort(int[] arr, int exp){
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++){
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--){
            int idx = (arr[i] / exp) % 10;
            output[count[idx] - 1] = arr[i];
            count[idx]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args){
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Original: ");
        for (int x : arr) System.out.print(x + " ");

        radixSort(arr);

        System.out.println("\nSorted: ");
        for (int x : arr) System.out.print(x + " ");
    }
}
