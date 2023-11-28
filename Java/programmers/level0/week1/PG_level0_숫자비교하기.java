package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_숫자비교하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int result = solution(num1, num2);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
	}
	
    public static int solution(int num1, int num2) {
        int answer = 0;
        
        if(num1 == num2) {
        	answer = 1;
        } else {
        	answer = -1;
        }
        return answer;
    }

}