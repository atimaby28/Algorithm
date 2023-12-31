package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_세균증식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int result = solution(n, t);
		
		bw.write(result + "\n");
	
		bw.flush();
		bw.close();
		
	}
	
    public static int solution(int n, int t) {
        int answer = n;
        
        for (int i = 1; i <= t; i++) {
			answer = answer * 2;
		}
        
        return answer;
    }
    
//    public int solution(int n, int t) {
//        int answer = 0;
//
//        answer = n << t;
//
//        return answer;
//    }

}