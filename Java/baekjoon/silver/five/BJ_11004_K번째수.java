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

    public static void quickSort(int[] array, int start, int end, int k) {

        if(start >= end) return;

        int pivot = whilePartition(array, start, end);

        if (k < pivot) {  // k가 pivot보다 작으면 왼쪽만 정렬
            quickSort(array, start, pivot - 1, k);
        } else if (k > pivot) {  // k가 pivot보다 크면 왼쪽만 정렬
            quickSort(array, pivot + 1, end, k);
        }
    }

    // Pivot을 중앙값으로 선택 O(nlogn)
    private static int whilePartition(int[] array, int left, int right) {
        int mid = (left + right) / 2;

        swap(array, left, mid); // 중앙값을 1번째 요소로 이동하기

        int pivot = array[left];
        int leftAreaIdx = left + 1, rightAreaIdx = right;

        while (leftAreaIdx <= rightAreaIdx) {
            while (leftAreaIdx <= right && array[leftAreaIdx] < pivot) {  // 피벗보다 큰 수가 나올 때까지 leftIdx++
                leftAreaIdx++;
            }
            while (rightAreaIdx >= left + 1 && array[rightAreaIdx] > pivot) {   // 피벗보다 작은 수가 나올 때까지 rightIdx--
                rightAreaIdx--;
            }

            if (leftAreaIdx <= rightAreaIdx) {
                swap(array, leftAreaIdx, rightAreaIdx);  // 찾은 leftIdx와 rightIdx를 교환하기
                leftAreaIdx++;
                rightAreaIdx--;
            }
        }

        // 피벗을 올바른 위치로 설정하기 (swap 사용)
        swap(array, left, rightAreaIdx);

        return rightAreaIdx;
    }


    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
