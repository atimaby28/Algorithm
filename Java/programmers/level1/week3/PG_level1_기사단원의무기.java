package level1.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level1_기사단원의무기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int power = Integer.parseInt(st.nextToken());

        int result = solution(number, limit, power);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;

        int[] iron = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            iron[i] = divNum(i);
        }

        for (int i = 0; i < iron.length; i++) {
            if(iron[i] > limit) {
                answer += power;
            } else {
                answer += iron[i];
            }
        }

        return answer;
    }

    private static int divNum(int i) {
        int cnt = 0;
        for (int j = 1; j * j  <= i; j++) {
            if(j * j ==i) {
                cnt++;
            } else if(i % j == 0) {
                cnt += 2;
            }
        }
        return cnt;
    }

}
