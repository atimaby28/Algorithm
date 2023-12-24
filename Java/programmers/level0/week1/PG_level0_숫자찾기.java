package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_숫자찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int result = solution(num, k);
		
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		
	}
	
    public static int solution(int num, int k) {
        int answer = -1;
        
        String str = num + "";

        for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) - '0' == k) {
				answer = i + 1;
				break;
			}
		}
        
        return answer;
    }

}
