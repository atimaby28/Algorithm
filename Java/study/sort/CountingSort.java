package sort;

public class CountingSort {
    public static int N = 10;
    public static int[] Arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void main(String[] args) {

        countingSort(Arr);

        for (int i : Arr) {
            System.out.print(i + " ");
        }
    }

    private static void countingSort(int[] arr) {
        // 최대값 구하기
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        int[] counting = new int[max + 1]; // 카운팅 배열

        for (int i = 0; i < N; i++) {
            counting[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < counting.length; i++) {
            while (counting[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }
}
