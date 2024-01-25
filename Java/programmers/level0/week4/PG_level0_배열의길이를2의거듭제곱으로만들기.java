package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_배열의길이를2의거듭제곱으로만들기 {

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
        int[] answer = arr;

        int i = 2;

        while(arr.length > i) {
            i *= 2;
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[answer.length - 1] = 0;
        }
        return answer;
    }

}
