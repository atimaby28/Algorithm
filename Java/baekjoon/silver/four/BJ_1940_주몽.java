package silver.four;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] iron = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < iron.length; i++) {
            iron[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(iron, m);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static int solution(int[] iron, int m) {
        int answer = 0;

        Arrays.sort(iron);

        int i = 0;
        int j = iron.length - 1;

        while (j > i) {
            if(iron[i] + iron[j] < m) {
                i++;
            } else if(iron[i] + iron[j] > m){
                j--;
            } else {
                answer += 1;
                i++;
                j--;
            }
        }

        return answer;
    }
}
