package level2.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_프로세스 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] priorities = new int[k];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < priorities.length; i++) {
            priorities[i] = Integer.parseInt(st.nextToken());
        }

        int location = Integer.parseInt(st.nextToken());

        int result = solution(priorities, location);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        

        return answer;
    }

}
