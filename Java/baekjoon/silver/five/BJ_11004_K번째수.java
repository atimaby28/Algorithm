package silver.five;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(nums, k);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k - 1); // k는 1-based 인덱스이므로 0-based로 변환

        return nums[k - 1]; // k번째 수 반환
    }

    private static void quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) return;

        int pivotIdx = findPivot(nums, left, right);

        if (k < pivotIdx) {
            quickSort(nums, left, pivotIdx - 1, k);
        } else if (k > pivotIdx) {
            quickSort(nums, pivotIdx + 1, right, k);
        }
    }

    private static int findPivot(int[] nums, int left, int right) {
        int pivot = nums[left];
        int leftAreaIdx = left + 1;
        int rightAreaIdx = right;

        while (leftAreaIdx <= rightAreaIdx) {
            while (leftAreaIdx <= rightAreaIdx && nums[leftAreaIdx] < pivot) {
                leftAreaIdx++;
            }
            while (leftAreaIdx <= rightAreaIdx && nums[rightAreaIdx] > pivot) {
                rightAreaIdx--;
            }

            if (leftAreaIdx <= rightAreaIdx) {
                swap(nums, leftAreaIdx, rightAreaIdx);
                leftAreaIdx++;
                rightAreaIdx--;
            }
        }

        swap(nums, left, leftAreaIdx - 1);

        return leftAreaIdx - 1; // Pivot의 최종 위치 반환
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
