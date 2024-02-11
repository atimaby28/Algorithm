package level1.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level1_나누어떨어지는숫자배열 {

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

        int divisor= Integer.parseInt(br.readLine());

        int[] result = solution(arr, divisor);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = arr[i];
            }
        }

        if(answer.length == 0) {
            answer = new int[]{-1};
        }

        return answer;
    }

}
