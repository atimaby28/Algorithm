package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_조건에맞게수열변환하기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine())

        int[] result = solution(arr, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];

        if(k % 2 != 0) {
            for (int i = 0; i < answer.length; i++) {
                answer[i] = arr[i] * k;
            }
        } else {
            for (int i = 0; i < answer.length; i++) {
                answer[i] = arr[i] + k;
            }
        }

        return answer;
    }

}
