package lis;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Lis_BinarySearch {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static int solution(int n, int[] arr) {
        int answer = 0;

        int[] dp = new int[n];

//        Arrays.sort(arr);

        int len = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > dp[len]) {
                len += 1;
                dp[len] = arr[i];
            } else {
                int idx = binarySearch(dp, 0, len, arr[i]);
                dp[idx] = arr[i];
            }
        }

        answer = len;

        return answer;
    }

//    이분 탐색을 활용하는 경우에는 정확한 LIS가 아닌 LIS의 길이를 구할 때 사용됩니다.
    static int binarySearch(int[] dp, int left, int right, int key) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (dp[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
