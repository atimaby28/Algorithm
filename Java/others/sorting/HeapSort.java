package sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10, 26, 89, 102, 6};
        System.out.println("Original array: " + Arrays.toString(array));

        heapSort(array);  // Sorts the array in-place

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    private static void heapSort(int[] array) {
        int n = array.length;

        // 배열에서 부모 노드부터 루트 노드까지 반복하여 최대 힙을 만듦
        for (int i = n / 2 - 1; i >= 0 ; i--) {
            heapify(array, n, i);
        }

        // 배열의 끝부터 시작하여 원소를 설정
        for (int i = n - 1; i >= 0; i--) {
            // 현재 루트 노드와 마지막 노드를 교환
            swap(array, 0 , i);
            // 남은 원소들을 대상으로 최대 힙을 유지
            heapify(array, i, 0);
        }
    }

    // 주어진 인덱스를 기준으로 최대 힙을 유지하는 함수
    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 왼쪽 자식이 부모보다 크면 왼쪽 자식을 largest로 변경
        if(left < n && array[left] > array[largest]) {
            largest = left;
        }

        // 오른쪽 자식이 부모보다 크면 오른쪽 자식을 largest로 변경
        if(right < n && array[right] > array[largest]) {
            largest = right;
        }

        // largest가 i와 다른 경우 두 원소를 교환하고 하위 트리를 재귀적으로 정렬
        if(largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
