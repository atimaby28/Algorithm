package twopointer;

import java.io.*;
import java.util.StringTokenizer;

public class 연속부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        int result = solution(array, target);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int[] array, int target) {
        int answer = 0;

        int lt = 0, rt = 0;

        int sum = 0;
        while (lt < array.length && rt < array.length) {
            if(sum < target) {
                sum += array[rt++];
            } else {
                sum -= array[lt++];
            }

            if(sum == target) {
                answer++;
            }
        }



        return answer;
    }

}

/*

input :
8
1 2 1 3 1 1 1 2
6

output :
3

 */
