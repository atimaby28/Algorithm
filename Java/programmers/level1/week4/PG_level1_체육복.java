package level1.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level1_체육복 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int p = Integer.parseInt(br.readLine());

        int[] lost = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lost.length; i++) {
            lost[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        int[] reserve = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < reserve.length; i++) {
            reserve[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(n, lost, reserve);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] possible = new int[n + 1];

        for (int i = 0; i < reserve.length; i++) {
            if (reserve[i] - 1 >= 1) {
                possible[reserve[i] - 1] = 1;
            }
            if (reserve[i]  + 1 <= n) {
                possible[reserve[i] + 1] = 1;
            }
            possible[reserve[i]] = 2;
        }

        System.out.println(Arrays.toString(possible));



        for (int i = 0; i < lost.length; i++) {
            if(possible[lost[i]] == 1 && possible[lost[i] + 1] == 2) {
                possible[lost[i]] = 0;
                possible[lost[i] + 1] = 0;
            } else if (possible[lost[i]] == 1 && possible[lost[i] - 1] == 2) {
                possible[lost[i]] = 0;
                possible[lost[i] - 1] = 0;
            }
        }

        int cnt = 0;
        for (int i = 1; i < possible.length; i++) {
            if(possible[i] == 2 || possible[i] == 0) {
                answer++;
            }
        }
        System.out.println(Arrays.toString(possible));



        return answer;
    }

}
