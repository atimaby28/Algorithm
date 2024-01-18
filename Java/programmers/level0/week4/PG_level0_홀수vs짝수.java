package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_홀수vs짝수 {

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

        int result = solution(num_list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] num_list) {
        int answer = 0;

        int[] sum = {0, 0};

        answer = oddEven(num_list, num_list.length - 1, sum);

        return answer;
    }

    private static int oddEven(int[] numList, int index, int[] sum) {
        if(index < 0) {
            return sum[0] > sum[1] ? sum[0] : sum[1];
        } else {
            if(index % 2 != 0) {
                sum[0] += numList[index];
            } else {
                sum[1] += numList[index];
            }
        }

        return oddEven(numList, index - 1, sum);

    }

}
