package sort;

public class BubbleSort {

    public static int N = 10;
    public static int[] Arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

    public static void main(String[] args) {

        bubbleSort(Arr, N);


        for (int i : Arr) {
            System.out.print(i + " ");
        }

    }
    public static void bubbleSort(int[] arr, int N) {
        for(int i = N - 1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
