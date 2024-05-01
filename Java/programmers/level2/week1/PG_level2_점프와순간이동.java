package level2.week1;

import java.io.*;

public class PG_level2_점프와순간이동 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = solution(N);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int n) {
        int ans = 0;

        while(n != 0) {
            if(n % 2 != 0) {
                n = n - 1;
                ans++;
            } else {
                n = n / 2;
            }
        }

        return ans;
    }
}
