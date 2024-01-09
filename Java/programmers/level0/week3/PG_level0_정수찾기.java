package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_정수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        int[] num_list = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num_list.length; i++) {
            num_list[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        int result = solution(num_list, n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] num_list, int n) {
        int answer = 0;

        answer = found(num_list, n, 0);

        return answer;
    }

    private static int found(int[] numList, int n, int i) {

        if(numList[i] == n) {
            return 1;
        } else if(i == numList.length - 1){
            return 0;
        }

        return found(numList, n, i + 1);
    }

}
