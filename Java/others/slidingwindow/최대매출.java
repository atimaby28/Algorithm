package slidingwindow;

import java.io.*;
import java.util.StringTokenizer;

public class 최대매출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] days = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < days.length; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        int result = solution(days, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int[] days, int k) {
        int answer = 0;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += days[i];
        }

        for (int i = k; i < days.length; i++) {
            sum += days[i] - days[i - k];

            answer = Math.max(answer, sum);
        }

        return answer;
    }

}

/*

input :
10
12 15 11 20 25 10 20 19 13 15
3

output :
56

 */
