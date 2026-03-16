import java.util.*;

public class MyHeapSort {

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void heapify(String[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].compareTo(arr[largest]) > 0)
            largest = left;

        if (right < n && arr[right].compareTo(arr[largest]) > 0)
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
        public static void buildHeapBottomUp(String[] arr) {

        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
}
 public static void heapSort(String[] arr) {

        int n = arr.length;

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
     public static void insert(String[] heap, int index) {

        int parent;

        while (index > 0) {

            parent = (index - 1) / 2;

            if (heap[index].compareTo(heap[parent]) > 0) {

                swap(heap, index, parent);
                index = parent;

            } else {
                break;
            }
        }
    }
    public static void buildHeapTopDown(String[] arr) {

        for (int i = 1; i < arr.length; i++) {
            insert(arr, i);
        }
    }

