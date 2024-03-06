package level2.week1;

import java.io.*;
import java.util.*;

public class PG_level2_귤고르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int[] tangerine = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tangerine.length; i++) {
            tangerine[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(k, tangerine);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        int[] tangerBox = new int[10000001];

        for (int i = 0; i < tangerine.length; i++) {
            tangerBox[tangerine[i]]++;
        }

        Arrays.sort(tangerBox);

        int tangerType = 0;
        int tangerWeight = 0;
        for (int i = tangerBox.length - 1; i >= 0 ; i--) {
            if(tangerBox[i] != 0 && tangerWeight < k) {
                tangerWeight += tangerBox[i];
                tangerType++;
            }
        }

        System.out.println(tangerType);

        return answer;
    }

}
