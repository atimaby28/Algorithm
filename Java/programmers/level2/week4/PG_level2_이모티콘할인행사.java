package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_이모티콘할인행사 {

    public static int joinMember = 0;
    public static int totalRevenue = 0;

    public static boolean[] visited;
    public static double[] rate = {0.1, 0.2, 0.3, 0.4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] users = new int[r][c];

        for (int i = 0; i < users.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < users[i].length; j++) {
                users[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int n = Integer.parseInt(br.readLine());

        int[] emoticons = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < emoticons.length; i++) {
            emoticons[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(users, emoticons);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        visited = new boolean[rate.length];
        permutation(rate, 0, new double[emoticons.length], users, emoticons);

        answer = new int[]{joinMember, totalRevenue};

        return answer;
    }

    private static void permutation(double[] rate, int depth, double[] output, int[][] users, int[] emoticons) {
        if(depth == output.length) {

            discounted(users, output, emoticons);

            return;
        }

        for (int i = 0; i < rate.length; i++) {
            visited[i] = true;
            output[depth] = rate[i];
            permutation(rate, depth + 1, output, users, emoticons);
            visited[i] = false;
        }

    }

    private static void discounted(int[][] users, double[] output, int[] emoticons) {

        int memberCnt = 0;
        int revenue = 0;
        for (int i = 0; i < users.length; i++) {
            int price = 0;
            for (int j = 0; j < output.length; j++) {
                if(output[j] * 100 >= users[i][0]) {
//                    price += (int)(emoticons[j] * (1.0 - output[j])); testcase 13, 15, 18번에서 오류를 일으킴
                    price += emoticons[j] * (1.0 - output[j]);
                }
            }

            if(users[i][1] <= price) {
                memberCnt++;
            } else {
                revenue += price;
            }
        }

        if(joinMember <= memberCnt) {

            if(joinMember == memberCnt) {
                totalRevenue = Math.max(totalRevenue, revenue);
            } else {
                totalRevenue = revenue;
            }

            joinMember = memberCnt;
        }

    }

}

/*

2 2
40 10000
25 10000
2
7000 9000


7 2
40 2900
23 10000
11 5200
5 5900
40 3100
27 9200
32 6900
4
1300 1500 1600 4900
 */
