package level0.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_마지막두원소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] num_list = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num_list.length; i++) {
            num_list[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(num_list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] num_list) {
        int[] answer = {};

        answer = result(num_list, num_list.length - 1);

        answer[answer.length - 1] = answer[answer.length - 2] > answer[answer.length - 3] ? answer[answer.length - 2] - answer[answer.length - 3] : answer[answer.length - 2] * 2;

        return answer;
    }

    private static int[] result(int[] numList, int i) {
        if(i < 0) {
            return new int[0];
        }

        int[] temp = result(numList, i - 1);

        int[] answer = {};
        if(i == 0) {
            answer = Arrays.copyOf(temp, temp.length + 2);
        } else {
            answer = Arrays.copyOf(temp, temp.length + 1);
        }

        answer[answer.length - 2] = numList[i];

        return answer;
    }

}
