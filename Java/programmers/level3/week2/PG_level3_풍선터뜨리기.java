package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(a);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }


    public static int solution(int[] a) {
        int answer = 0;



        return answer;
    }

}
