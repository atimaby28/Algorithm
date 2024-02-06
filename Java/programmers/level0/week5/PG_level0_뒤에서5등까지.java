package level0.week5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_뒤에서5등까지 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] num_list = new int[n];

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
        int[] answer = new int[5];

        Arrays.sort(num_list);

        for (int i = 0; i < 5; i++) {
            answer[i] = num_list[i];
        }

        return answer;
    }

}
