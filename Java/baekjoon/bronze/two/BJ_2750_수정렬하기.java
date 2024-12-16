package bronze.two;

import java.io.*;
import java.util.Arrays;

public class BJ_2750_수정렬하기 {
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

        bubbleSort(nums);

        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append("\n");
        }
        return sb.toString();
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
