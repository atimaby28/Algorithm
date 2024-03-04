package level2.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_최솟값만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] A = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());
        int[] B = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(A, B);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int []A, int []B) {
        int answer = 0;


        return answer;
    }

}
