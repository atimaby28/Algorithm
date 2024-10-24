package sorting;

/*
              left part                           right part
      +-----------------------+             +-----------------------+
      |   element < pivot     |    pivot    |    element > pivot    |
      +-----------------------+             +-----------------------+
    left                pivot - 1        pivot + 1                right

 */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10, 26, 89, 102, 6};
        System.out.println("Original array: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);  // QuickSort 호출

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    // Method to perform QuickSort on the array
    public static void quickSort(int[] array, int leftIdx, int rightIdx) {

        if (rightIdx <= leftIdx) return;

        // Partition the array and get the pivot index
        int pivotIndex = whilePartition(array, leftIdx, rightIdx);

        // Recursively sort elements before and after partition
        quickSort(array, leftIdx, pivotIndex - 1);   // Sort left side of pivot
        quickSort(array, pivotIndex + 1, rightIdx);  // Sort right side of pivot
    }

    // while loop partition
    private static int whilePartition(int[] array, int leftIdx, int rightIdx) {
        int pivot = array[leftIdx]; // Choose the first element as the pivot

        int leftStartIdx = leftIdx + 1; // Start from the next element
        int rightStartIdx = rightIdx; // Right index

        while (leftStartIdx <= rightStartIdx) {
            // Find the first element greater than or equal to the pivot from the left
            while (leftStartIdx <= rightIdx && array[leftStartIdx] < pivot) {
                leftStartIdx++;
            }

            // Find the first element less than or equal to the pivot from the right
            while (rightStartIdx >= leftIdx + 1 && array[rightStartIdx] > pivot) {
                rightStartIdx--;
            }

            // Swap if the indices haven't crossed
            if (leftStartIdx < rightStartIdx) {
                swap(array, leftStartIdx, rightStartIdx);
            }
        }

        // Place the pivot in its correct position
        swap(array, leftIdx, rightStartIdx);

        return rightStartIdx; // Return the new pivot position
    }

    // for loop partition
    private static int forPartition(int[] array, int leftIdx, int rightIdx) {
        int pivot = array[leftIdx]; // Choosing the first element as the pivot
        int leftStartIdx = leftIdx + 1; // Pointer for the larger element

        for (int rightStartIdx = leftIdx + 1; rightStartIdx <= rightIdx; rightStartIdx++) {
            if (array[rightStartIdx] < pivot) {
                swap(array, leftStartIdx, rightStartIdx); // Swap if the element is less than the pivot
                leftStartIdx++;
            }
        }

        swap(array, leftIdx, leftStartIdx - 1); // Place pivot in the correct position

        return leftStartIdx - 1; // Return the partition index
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}