package silver.four;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(nums);

        bw.write(result + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(int[] nums) {

        insertionSort(nums);

        int sum = 0, answer = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i]);
            answer += sum;
        }

        return answer;
    }

    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > target) {
                nums[j + 1] = nums[j--];
            }

            nums[j + 1] = target;
        }
    }
}
