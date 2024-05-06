package sorting;

public class SelectionSort {
    public static int N = 10;
    public static int[] Arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

    public static void main(String[] args) {

        for (int i : selectionSort(Arr, N)) {
            System.out.print(i + " ");
        }

    }

    private static int[] selectionSort(int[] arr, int n) {

        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < arr[idx]) {
                    idx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;

        }

        return arr;

    }
}
