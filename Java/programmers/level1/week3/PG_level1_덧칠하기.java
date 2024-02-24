package level1.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level1_덧칠하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        int[] section = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < section.length; i++) {
            section[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, m, section);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] fence = new boolean[n + 1];

        for (int i = 0; i < section.length; i++) {
            fence[section[i]] = true;
        }

        for (int i = 1; i < fence.length; i++) {
            if(fence[i]) {
                answer++;
                for (int j = 0; j < m; j++) {
                    if(i + j < fence.length && fence[i + j]) {
                        fence[i + j] = false;
                    }
                }
            }
        }
        return answer;
    }

}
