package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_가까운1찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] arr = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = Integer.parseInt(br.readLine());

        int result = solution(arr, idx);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] arr, int idx) {
        int answer = -1;

        for (int i = idx; i < arr.length; i++) {
            if(arr[i] == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

}
