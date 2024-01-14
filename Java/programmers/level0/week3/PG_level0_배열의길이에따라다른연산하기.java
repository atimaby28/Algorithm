package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_배열의길이에따라다른연산하기 {

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

        int n = Integer.parseInt(br.readLine());

        int[] result = solution(arr, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] arr, int n) {
        int[] answer = new int[arr.length];

        answer = addArr(arr, n, 0, answer);

        return answer;
    }

    private static int[] addArr(int[] arr, int n, int i, int[] answer) {

        if(i == arr.length) {
            return answer;
        } else {
            if(arr.length % 2 != 0 && i % 2 == 0) {
                answer[i] = arr[i] +  n;
            } else if(arr.length % 2 == 0 && i % 2 != 0) {
                answer[i] = arr[i] + n;
            } else {
                answer[i] = arr[i];
            }
        }

        return addArr(arr, n, i + 1, answer);

    }

}
