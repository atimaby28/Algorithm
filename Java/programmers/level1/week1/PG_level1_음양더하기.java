package level1.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_음양더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] absolutes = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < absolutes.length; i++) {
            absolutes[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        boolean[] signs = new boolean[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < signs.length; i++) {
            signs[i] = Boolean.parseBoolean(st.nextToken());
        }

        int result = solution(absolutes, signs);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if(signs[i] == true) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }

//    public int solution(int[] absolutes, boolean[] signs) {
//        int answer = 0;
//        for (int i=0; i<signs.length; i++)
//            answer += absolutes[i] * (signs[i]? 1: -1);
//        return answer;
//    }

}
