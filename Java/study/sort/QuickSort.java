package sort;

/*
              left part                           right part
      +-----------------------+             +-----------------------+
      |   element <= pivot    |    pivot    |    element > pivot    |
      +-----------------------+             +-----------------------+
      p                pivot - 1        pivot + 1                   q

 */

public class QuickSort {

    public static int N = 10;
    public static int[] Arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void main(String[] args) {

        quickSort(Arr, 0, N - 1);


        for (int i : Arr) {
            System.out.print(i + " ");
        }

    }

    public static void quickSort(int[] arr, int p, int q) {
        if (p < q) {
            int pivot = partition(arr, p, q);
            quickSort(arr, p, pivot - 1);
            quickSort(arr, pivot + 1, q);
        }
    }

    public static int partition(int[] arr, int p, int q) {
        int pivot = arr[q];
        int i = p - 1;

        for (int j = p; j < q; j++) {
            if (arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, q);

        return i + 1;
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
