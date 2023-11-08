package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_종이자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int result = solution(M, N);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int M, int N) {
        int answer = 0;
        
        answer = M * N - 1;
        
        return answer;
    }

}
