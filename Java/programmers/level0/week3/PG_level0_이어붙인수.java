package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_이어붙인수 {

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

        String[] sum = {"", ""};

        answer = sumOddEven(num_list, 0, sum);

        return answer;
    }

    private static int sumOddEven(int[] numList, int length, String[] sum) {
        if(length == numList.length) {
          return Integer.parseInt(sum[0]) + Integer.parseInt(sum[1]);
        } else {
          if(numList[length] % 2 == 0) {
              sum[0] += numList[length];
          } else {
              sum[1] += numList[length];
          }
        }

        return sumOddEven(numList, length + 1, sum);

    }

}
