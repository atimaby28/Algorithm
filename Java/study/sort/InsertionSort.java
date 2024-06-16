package sort;

public class InsertionSort {

    public static int N = 10;
    public static int[] Arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

    public static void main(String[] args) {

        insertionSort(Arr, N);


        for (int i : Arr) {
            System.out.print(i + " ");
        }

    }

    public static void insertionSort(int[] arr, int N) {
        for(int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i - 1;

            // 이전의 원소가 더 크다면 데이터는 하나씩 밀려난다.
            while (j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = target;
        }
    }
}
