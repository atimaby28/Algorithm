package silver.five;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ_2751_수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        String result = solution(nums);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static String solution(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);

        return IntStream.of(nums) // IntStream 생성
                .mapToObj(String::valueOf) // 각 정수를 문자열로 변환
                .collect(Collectors.joining("\n"));
    }

    // 병합 정렬 메서드
    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return; // 배열의 크기가 1이면 정렬 완료
        }

        int mid = (left + right) / 2;

        // 좌우 반으로 나누어 재귀적으로 정렬
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);

        // 분할된 배열을 병합
        merge(array, left, mid, right);
    }

    // 병합 메서드
    private static void merge(int[] array, int left, int mid, int right) {
        // 임시 배열 생성
        int[] temp = new int[right - left + 1];

        int i = left;      // 왼쪽 배열의 시작
        int j = mid + 1;   // 오른쪽 배열의 시작
        int k = 0;         // 임시 배열의 인덱스

        // 두 부분 배열을 비교하며 병합
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // 남은 요소 처리 (왼쪽 배열)
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // 남은 요소 처리 (오른쪽 배열)
        while (j <= right) {
            temp[k++] = array[j++];
        }

        // 임시 배열의 내용을 원본 배열로 복사
        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
