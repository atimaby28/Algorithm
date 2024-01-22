package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_등차수열의특정한항만더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        boolean[] included = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < included.length; i++) {
            included[i] = Boolean.parseBoolean(st.nextToken());
        }

        int result = solution(a, d, included);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int a, int d, boolean[] included) {
        int answer = 0;

        for (int i = 0; i < included.length; i++) {
            if(included[i] == true) {
                answer += a + ((i + 1) - 1) * d;
            }
        }

        return answer;
    }

}
