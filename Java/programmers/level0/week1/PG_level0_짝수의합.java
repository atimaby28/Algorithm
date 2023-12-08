package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_짝수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int result = solution(n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
	}

	public static int solution(int n) {
		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				answer += i;
			}
		}

//        for(int i=2; i<=n; i+=2){
//            answer+=i;
//        }

		return answer;
	}

}