package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_원소들의곱과합 {
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

        int result = solution(num_list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] num_list) {
        int answer = 0;

        int mul = 1, sum = 0;
        for (int i : num_list) {
            mul *= i;
            sum += i;
        }

        if(mul < sum * sum) {
            answer = 1;
        }

        return answer;
    }

}
