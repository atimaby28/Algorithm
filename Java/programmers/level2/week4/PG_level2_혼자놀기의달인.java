package level2.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level2_혼자놀기의달인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] cards = new int[k];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(cards);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[] cards) {
        int answer = 1;

        int[] groupIdx = new int[100];
        boolean[] check = new boolean[cards.length];

        int idx = 0, start = 0, cnt = 0;
        boolean flag = true;
        while (flag) {

            if(!check[idx]) {
                check[idx] = true;
                cnt++;
                groupIdx[start]++;
                idx = cards[idx] - 1;
            } else {

                for (int i = 0; i < check.length; i++) {
                    if(!check[i]) {
                        idx = i;
                        start++;
                        break;
                    }
                }
            }
            if(cnt == cards.length) {
                flag = false;
                break;
            }
        }

        Arrays.sort(groupIdx);

        answer = groupIdx[groupIdx.length - 1] * groupIdx[groupIdx.length - 2];

        return answer;
    }

}
