package sorting;

public class InsertionSort {

    public static int N = 10;
    public static int[] Arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

    public static void main(String[] args) {




        for (int i : insertionSort(Arr, N)) {
            System.out.print(i + " ");
        }

    }

    private static int[] insertionSort(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0 ; j--) {
                if(arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }

        return arr;
    }

}
