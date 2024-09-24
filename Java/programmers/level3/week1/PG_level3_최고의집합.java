package level3.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_최고의집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(st.nextToken());


        int[] result = solution(n, s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int n, int s) {
        int[] answer = {};


        

        return answer;
    }
}
