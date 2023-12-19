package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_점의위치구하기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dot = new int[2];
		
		dot[0] = Integer.parseInt(st.nextToken());
		dot[1] = Integer.parseInt(st.nextToken());
		
		double result = solution(dot);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int[] dot) {
        int answer = 0;
        
        if(dot[0] > 0 && dot[1] > 0) {
        	answer = 1;
        } else if(dot[0] < 0 && dot[1] > 0) {
        	answer = 2;
        } else if(dot[0] < 0 && dot[1] < 0) {
        	answer = 3;
        } else {
        	answer = 4;
        }
        
        return answer;
    }

}