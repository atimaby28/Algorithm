package level0.week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_n의배수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(st.nextToken());
		
		int result = solution(num, n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}

    public static int solution(int num, int n) {
        int answer = 0;
        
        if(num % n == 0) {
        	answer = 1;
        }
        
        return answer;
    }
    
}
