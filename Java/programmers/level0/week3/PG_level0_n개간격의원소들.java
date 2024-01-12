package level0.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_n개간격의원소들 {
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

        int n = Integer.parseInt(br.readLine());

        int[] result = solution(num_list, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] num_list, int n) {
        int[] answer = {};

        int[] temp = jumpArr(num_list, n, 0);

        answer = new int[temp.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp[temp.length - 1 - i];
        }

        return answer;
    }

    private static int[] jumpArr(int[] num_list, int n, int i) {
        if(i >= num_list.length) {
            return new int[0];
        }

        int[] rew = jumpArr(num_list, n,  i + n);
        int[] result = Arrays.copyOf(rew, rew.length + 1);

        result[result.length - 1] = num_list[i];

        return result;
    }

}
