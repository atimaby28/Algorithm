package level1.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level1_제일작은수제거하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] numbers = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(numbers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int[] solution(int[] arr) {
        int[] answer = {};

        int min = arr[0];
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(i == idx) {
                continue;
            } else {
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
