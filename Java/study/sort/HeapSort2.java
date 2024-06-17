package sort;

public class HeapSort2 {

    public static int N = 10;
    public static int[] Arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void main(String[] args) {

        heapSort(Arr);

        for (int i : Arr) {
            System.out.print(i + " ");
        }

    }

    public static void heapSort(int[] arr) {
        int lastIndex = arr.length - 1;

        buildHeap(arr, lastIndex);

        for (int i = 0; i < lastIndex; i++) { //sort by remove the largest and put at the end
            int size = lastIndex - i; //new size after remove last
            arr[size] = remove(arr, size, i); //put the largest at the end
        }
    }

    public static void buildHeap(int[] arr, int lastIndex) {
        int parent = (lastIndex - 1) / 2;

        for (int i = parent; i >= 0; i--) {//make the array a max heap
            heapify(arr, lastIndex, i);
        }
    }

    private static int remove(int[] a, int size, int i) {
        int max = a[0];
        a[0] = a[size]; //put last at front
        heapify(a, size, 0);
        return max;
    }

    public static void heapify(int[] a, int size, int i) {
        int top = a[i];
        int larger;

        while (i < size / 2) { // from top down, swap with larger child
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (right < size && a[right] > a[left])
                larger = right;
            else
                larger = left;

            if (top >= a[larger])
                break;

            a[i] = a[larger];
            i = larger;
        }
        a[i] = top;
    }

}
