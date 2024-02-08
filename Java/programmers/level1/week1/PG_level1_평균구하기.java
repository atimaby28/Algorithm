package level1.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_평균구하기 {

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

        double result = solution(arr);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static double solution(int[] arr) {
        double answer = 0;

        for (int n : arr) {
            answer += n;
        }

        return answer / arr.length;
    }
}
