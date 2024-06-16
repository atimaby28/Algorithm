package sorting;

public class BubbleSort {
    public static int N = 10;
    public static int[] Arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

    public static void main(String[] args) {

        for (int i : bubbleSort(Arr, N)) {
            System.out.print(i + " ");
        }

    }

    private static int[] bubbleSort(int[] arr, int n) {

        // round는 배열 크기 - 1 만큼 진행됨
        for (int i = 0; i < n - 1; i++) {

            // 각 라운드별 비교횟수는 배열 크기의 현재 라운드를 뺀 만큼 비교함
            for (int j = 0; j < (n - 1) - i; j++) {

                //현재 원소가 다음 원소보다 클 경우 서로 원소의 위치를 교환한다.
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}
