package sort;

public class SelectionSort {
    public static int N = 10;
    public static int[] Arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

    public static void main(String[] args) {

        selectionSort(Arr, N);


        for (int i : Arr) {
            System.out.print(i + " ");
        }

    }

    private static void selectionSort(int[] arr, int N) {

        for(int i = N - 1; i >= 0; i--) {
            int maxIndex = i;

            // 최솟값을 갖고있는 인덱스 찾기
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // i번째 값과 찾은 최솟값을 서로 교환
            swap(arr, i, maxIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
