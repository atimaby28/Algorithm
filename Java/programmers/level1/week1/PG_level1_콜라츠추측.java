package level1.week1;

import java.io.*;

public class PG_level1_콜라츠추측 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int num = solution(n);

        bw.write(num + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int num) {
        int answer = -1;

        if(num == 1) {
            return 0;
        }

        long trans = num;

        for (int i = 1; i <= 500; i++) {
            if(trans % 2 == 0) {
                trans /= 2;
            } else {
                trans = trans * 3 + 1;
            }

            if(trans == 1) {
                answer = i;
                break;
            }

        }

        return answer;
    }

}
