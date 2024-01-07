package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_조건에맞게수열변환하기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] arr) {
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 50 && arr[i] % 2 != 0) {
                answer[i] = arr[i] * 2;
            } else if (arr[i] >= 50 && arr[i] % 2 == 0) {
                answer[i] = arr[i] / 2;
            } else {
                answer[i] = arr[i];
            }
        }

        return answer;
    }

}
