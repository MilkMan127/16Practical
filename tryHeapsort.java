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
      public static String[] testWords() {

        return new String[]{
                "apple","orange","banana","grape","pear",
                "kiwi","melon","peach","plum","mango",
                "berry","lime","lemon","fig","date",
                "guava","papaya","apricot","coconut","cherry"
        };
    }
public static void main(String[] args) {

        String[] words1 = testWords();
        String[] words2 = words1.clone();
         long start1 = System.nanoTime();

        buildHeapBottomUp(words1);
        heapSort(words1);

        long end1 = System.nanoTime();

        // Top-down timing
        long start2 = System.nanoTime();

        buildHeapTopDown(words2);
        heapSort(words2);

        long end2 = System.nanoTime();

        System.out.println("Sorted words (Bottom-Up):");
        System.out.println(Arrays.toString(words1));

        System.out.println("\nSorted words (Top-Down):");
        System.out.println(Arrays.toString(words2));

        System.out.println("\nTiming Results:");
        System.out.println("Bottom-Up Heap Build + Sort: " + (end1 - start1) + " ns");
        System.out.println("Top-Down Heap Build + Sort: " + (end2 - start2) + " ns");
    }
}
