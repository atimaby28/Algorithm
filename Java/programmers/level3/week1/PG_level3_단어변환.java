package level3.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level3_단어변환 {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String begin = st.nextToken();
        String target = st.nextToken();

        int k = Integer.parseInt(st.nextToken());

        String[] words = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < words.length; i++) {
            words[i] = st.nextToken();
        }

        int result = solution(begin, target, words);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean flag = false;

        for(String word : words) {
            if(target.equals(word)) flag = true;
        }

        if(flag) {
            visited = new boolean[words.length];

            answer = dfs(begin, target, words, 0);
        }

        return answer;
    }

    private static int dfs(String begin, String target, String[] words, int cnt) {

        if(begin.equals(target)) return cnt;

        int minCnt = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && isPossible(begin, words[i])) {
                visited[i] = true;
                minCnt = Math.min(minCnt, dfs(words[i], target, words, cnt + 1));
                visited[i] = false;
            }
        }

        return minCnt;

    }

    private static boolean isPossible(String begin, String word) {
        int diffCnt = 0;

        for (int i = 0; i < word.length(); i++) {
            if(begin.charAt(i) != word.charAt(i)) diffCnt++;
            if(diffCnt > 1) break;
        }

        if(diffCnt == 1) return true;
        else return false;

    }

}
