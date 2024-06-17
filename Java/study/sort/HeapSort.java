package sort;

public class HeapSort {

    public static int N = 10;
    public static int[] Arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };
    //public static int[] Arr = { 16, 14, 10, 8, 7, 9, 3, 2, 4, 1 };

    public static void main(String[] args) {

        heapSort(Arr);


        for (int i : Arr) {
            System.out.print(i + " ");
        }

    }

    public static void heapSort(int[] arr) {
        int lastIndex = arr.length - 1;

        buildHeap(arr, lastIndex);

        for(int i = lastIndex; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void buildHeap(int[] arr, int lastIndex) {
        int parent = (lastIndex - 1) / 2;

        for(int i = parent; i >= 0; i--) {
            heapify(arr, i, lastIndex);
        }
    }

    public static void heapify(int[] arr, int parentIndex, int lastIndex) {
        int leftChildIndex = parentIndex * 2 + 1;
        int rightChildIndex = parentIndex * 2 + 2;
        int largestIndex = parentIndex;

        // 자식 노드가 없는 경우
        if(leftChildIndex > lastIndex) {
            return;
        }

        // 현재 가장 큰 인덱스보다 왼쪽 자식노드의 값이 더 클경우
        if(leftChildIndex < lastIndex && arr[leftChildIndex] > arr[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        // 현재 가장 큰 인덱스보다 오른쪽 자식노드의 값이 더 클경우
        if(rightChildIndex < lastIndex && arr[rightChildIndex] > arr[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if(largestIndex != parentIndex) {
            swap(arr, largestIndex, parentIndex);
            heapify(arr, largestIndex, lastIndex);
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


}
