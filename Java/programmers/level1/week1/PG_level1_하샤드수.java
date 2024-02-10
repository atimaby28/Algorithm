package level1.week1;

import java.io.*;

public class PG_level1_하샤드수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        boolean result = solution(x);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static boolean solution(int x) {
        boolean answer = false;

        int target = x;
        int hasard = 0;

        while(x > 0) {
            hasard += x % 10;
            x /= 10;
        }

        if(target % hasard == 0) {
            answer = true;
        }

        return answer;
    }
}
