package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_빈배열에추가삭제하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] arr = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        boolean[] flag = new boolean[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < flag.length; i++) {
            flag[i] = Boolean.parseBoolean(st.nextToken());
        }

        int[] result = solution(arr, flag);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};

        for (int i = 0; i < arr.length; i++) {
            if(flag[i] == true) {
                answer = Arrays.copyOf(answer, answer.length + arr[i] * 2);
                for (int j = 1; j <= arr[i] * 2; j++) {
                    answer[answer.length - j] = arr[i];
                }
            } else {
                answer = Arrays.copyOf(answer, answer.length - arr[i]);
            }
        }

        for (int ans : answer) {
            System.out.print(ans);
        }

        return answer;
    }

}
