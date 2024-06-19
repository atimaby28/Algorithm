package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_택배배달과수거하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cap = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] deliveries = new int[n];
        int[] pickups = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < deliveries.length; i++) {
            deliveries[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pickups.length; i++) {
            pickups[i] = Integer.parseInt(st.nextToken());
        }

        long result = solution(cap, n, deliveries, pickups);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;

        int delivery = 0, pickup = 0;
        for (int i = n - 1; i >= 0; i--) {
            delivery += deliveries[i];
            pickup += pickups[i];

            while (delivery > 0 || pickup > 0) {
                delivery -= cap;
                pickup -= cap;

                answer += (i + 1) * 2L;
            }
        }


        return answer;
    }

}
