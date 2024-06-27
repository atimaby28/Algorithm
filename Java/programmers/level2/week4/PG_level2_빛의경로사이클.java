package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_빛의경로사이클 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        String[] grid = new String[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < grid.length; i++) {
            grid[i] = st.nextToken();
        }

        int[] result = solution(grid);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(String[] grid) {
        int[] answer = {};



        return answer;
    }

}
