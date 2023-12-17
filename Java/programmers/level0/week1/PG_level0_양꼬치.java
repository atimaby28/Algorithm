package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_양꼬치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		double result = solution(n, k);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int n, int k) {
        int answer = 0;
        
        int service = n / 10;
        k -= service;
        
        answer = n * 12000 + k * 2000;
        
        return answer;
    }

}