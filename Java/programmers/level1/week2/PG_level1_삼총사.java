package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_삼총사 {

    public static boolean[] visited;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] number = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(number);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] number) {
        int answer = 0;

        visited = new boolean[number.length];

        combination(number, visited, 0, number.length, 3);

        answer = ans;

        return answer;
    }

    static void combination(int[] number, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    sum += number[i];
                }
            }

            if(sum == 0) {
                ans++;
            }

            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(number, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }


}
