package sort;


/*
              left part                           right part
      +-----------------------+             +-----------------------+
      |        element        |    n / 2    |        element        |
      +-----------------------+             +-----------------------+
      p                       r             r + 1                   q

 */


public class MergeSort {

    public static int N = 10;
    public static int[] Arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };

    public static int[] temp;

    public static void main(String[] args) {

        mergeSort(Arr, 0, N - 1);


        for (int i : Arr) {
            System.out.print(i + " ");
        }

    }

    public static void mergeSort(int[] arr, int p, int q) {
        if(p < q) {
            int r = (p + q) / 2;
            mergeSort(arr, p, r);
            mergeSort(arr, r + 1, q);
            merge(arr, p, r, q);
        }
    }

    public static void merge(int[] arr, int p, int r, int q) {
        int i = p;
        int j = r + 1;
        int k = p;

        temp = new int[arr.length];

        while (i <=r && j <= q) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= r) {
            temp[k++] = arr[i++];
        }

        while(j <= q) {
            temp[k++] = arr[j++];
        }

        for (int x = p; x <= q; x++) {
            arr[x] = temp[x];
        }

    }

}
