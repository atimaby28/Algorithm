package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_부족한금액계산하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int price = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        long result = solution(price, money, count);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static long solution(int price, int money, int count) {
        long answer = 0;

        for (int i = 1; i <= count; i++) {
            answer += price * i;
        }

        answer = answer - money;

        if(answer < 0) {
            answer = 0;
        }

        return answer;
    }

}
