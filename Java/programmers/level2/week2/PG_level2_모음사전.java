package level2.week2;

import java.io.*;
import java.util.Arrays;

public class PG_level2_모음사전 {

    public static char[] aeiou = {'A', 'E', 'I', 'O', 'U'};
    public static boolean[] vistied = new boolean[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String word) {
        int answer = 0;

        dfs(0);

        return answer;
    }

    static void dfs(int nodeIndex) {
        // 방문 처리
        vistied[nodeIndex] = true;

        // 방문 노드 출력
        System.out.print(nodeIndex + " -> ");

        for (int i = 0; i < aeiou.length; i++) {
            if(!vistied[i]) {
                dfs(i);
            }
        }
    }

}
