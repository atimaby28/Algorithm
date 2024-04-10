package level2.week3;

import java.io.*;

public class PG_level2_마법의엘리베이터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int storey = Integer.parseInt(br.readLine());

        int result = solution(storey);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10;
            storey = storey / 10;

            if(digit > 5) {
                answer += (10 - digit);
                storey++;
            } else if(digit < 5) {
                answer += digit;
            } else {
                if(storey % 10 >= 5) {
                    answer += (10 - digit);
                    storey++;
                } else {
                    answer += digit;
                }
            }
        }

        return answer;
    }

}
