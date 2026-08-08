package Sorting;

public class HeapSort {
    
    public void sort(int arr[]) {
        int n = arr.length;

        //we check only for non-leaf nodes
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr,n,i);

        }
        for (int i =n -1; i >; i--) {
            swap(arr,0.i);

            heapify(arr,i,0);
        }
    }

    private void main(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;

    }

    private void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            swap(arr,i,largest);

            heapify(arr,n,largest);
        }
    }
}
