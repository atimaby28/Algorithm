package bronze.one;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 수정렬하기3 {

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
        StringBuilder sb = new StringBuilder();
        // Find the maximum number to determine the number of digits
        int max = Arrays.stream(nums).max().orElseThrow();

//         Perform counting sort for each digit
//         The digit place is passed as 1, 10, 100, ...
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(nums, place);
        }

        // 기수 정렬 수행
//        radixSort(nums, 10000); // 문제 조건에 따라 최대값 10,000으로 설정

        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append("\n");
        }

        return sb.toString();
    }

    // A function to do counting sort of arr[] according to the digit represented by place
    private static void countingSort(int[] arr, int place) {
        int n = arr.length;
        int[] count = new int[10];

        // Count occurrences
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / place) % 10;
            count[digit]++;
        }

        // Cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in sorted order
        int[] temp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / place) % 10;
            temp[--count[digit]] = arr[i];
        }

        // Copy sorted elements back to original array
        System.arraycopy(temp, 0, arr, 0, n);
    }

    public static void radixSort(int[] arr, int maxValue) {
        int exp = 1; // 1의 자리부터 시작
        int[] output = new int[arr.length];

        while (maxValue / exp > 0) {
            int[] count = new int[10]; // 0~9까지의 자릿수 개수

            // 현재 자릿수 기준으로 카운트
            for (int num : arr) {
                int digit = (num / exp) % 10;
                count[digit]++;
            }

            // 누적합 계산 (자리 정렬 순서를 유지하기 위해)
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // 출력 배열에 정렬된 값 저장
            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = (arr[i] / exp) % 10;
                output[--count[digit]] = arr[i];
            }

            // 정렬된 결과를 원본 배열로 복사
            System.arraycopy(output, 0, arr, 0, arr.length);

            // 다음 자릿수로 이동
            exp *= 10;
        }
    }

}
