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

            int minIdx = i;

            // 최솟값을 갖고있는 인덱스 찾기
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // i 번째 값과 찾은 최솟값을 서로 교환
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

        }

        return arr;

    }
}
