package sorting;

/*
              left part                           right part

  leftAreaIdx                          rightAreaIdx
      +-----------------------+             +-----------------------+
      |        element        |    n / 2    |        element        |
      +-----------------------+             +-----------------------+
   leftIdx                 midIdx        midIdx + 1            rightIdx

 */


import java.util.Arrays;

public class MergeSort {

    // Test the Bottom-Up MergeSort implementation
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10, 26, 89, 102, 6};
        System.out.println("Original array: " + Arrays.toString(array));

        bottomUpMergeSort(array, 0 , array.length - 1);  // Sorts the array in-place
//        topDownMergeSort(array, 0 , array.length - 1); // Sorts the array in-place

        System.out.println("Sorted array: " + Arrays.toString(array));
    }


    // Recursive function for Top-Down merge sort
    public static void topDownMergeSort(int[] array, int leftIdx, int rightIdx) {
        // Base case: if the array has one or no elements, it's already sorted
        if (leftIdx >= rightIdx) return;

        // Split the array in half and sort recursively
        int midIdx = (leftIdx + rightIdx) / 2;

        topDownMergeSort(array, leftIdx, midIdx);
        topDownMergeSort(array, midIdx + 1, rightIdx);

        // Merge the sorted halves
        merge(array, leftIdx, midIdx, rightIdx);
    }

    // Bottom-up Merge Sort function
    public static void bottomUpMergeSort(int[] array, int leftIdx, int rightIdx) {

        // Iterate over different subarray sizes (1, 2, 4, 8, ...)
        for (int size = 1; size <= rightIdx; size *= 2) {
            // Merge subarrays in pairs
            for (int leftAreaIdx = leftIdx; leftAreaIdx <= rightIdx - size; leftAreaIdx += 2 * size) {

                int midIdx = Math.min(leftAreaIdx + size - 1, rightIdx);
                int rightAreaIdx = Math.min(leftAreaIdx + 2 * size - 1, rightIdx);

                // Merge the subarrays array[leftIdx:mid] and array[mid:rightEnd]
                merge(array, leftAreaIdx, midIdx, rightAreaIdx);
            }
        }
    }

    // Merge function that both Top-Down and Bottom-Up approaches can use
    public static void merge(int[] array, int leftIdx, int midIdx, int rightIdx) {
        int[] aux = new int[array.length]; // Create auxiliary array for current merge
        int leftAreaIdx = leftIdx, rightAreaIdx = midIdx + 1, auxIdx = 0;

        // Merge the two halves into temp[]
        while (leftAreaIdx <= midIdx && rightAreaIdx <= rightIdx) {
            if (array[leftAreaIdx] <= array[rightAreaIdx]) {
                aux[auxIdx++] = array[leftAreaIdx++];
            } else {
                aux[auxIdx++] = array[rightAreaIdx++];
            }
        }

        // Copy remaining elements from the left half
        while (leftAreaIdx <= midIdx) {
            aux[auxIdx++] = array[leftAreaIdx++];
        }

        // Copy remaining elements from the right half
        while (rightAreaIdx <= rightIdx) {
            aux[auxIdx++] = array[rightAreaIdx++];
        }

        // Copy the sorted temp array back into the original array
        System.arraycopy(aux, 0, array, leftIdx, auxIdx);
    }
}