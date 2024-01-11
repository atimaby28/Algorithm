package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_배열비교하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[p];
        int[] arr2 = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(arr1, arr2);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] arr1, int[] arr2) {
        int answer = 0;

        answer = compareSums(arr1, arr2, 0);

        return answer;
    }

    public static int compareSums(int[] arr1, int[] arr2, int index) {
        int sum1 = calculateSum(arr1, index);
        int sum2 = calculateSum(arr2, index);

        if(arr1.length != arr2.length) {
            return arr1.length > arr2.length? 1 : -1;
        }

        return Integer.compare(sum1, sum2);
    }

    private static int calculateSum(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }

        return arr[index] + calculateSum(arr, index + 1);
    }

}
