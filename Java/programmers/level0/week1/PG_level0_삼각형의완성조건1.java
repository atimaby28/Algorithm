package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_삼각형의완성조건1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		int[] sides = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < sides.length; i++) {
			sides[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = solution(sides);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int[] sides) {
        int answer = 0;
        
        Arrays.sort(sides);
        
        if(sides[2] < sides[0] + sides[1]) {
        	answer = 1;
        } else {
        	answer = 2;
        }
        
        return answer;
    }

}