package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_진료순서정하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		int k = Integer.parseInt(br.readLine());
		
		int[] emergency = new int[k];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < emergency.length; i++) {
			emergency[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = solution(emergency);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();

	}
	
    public static int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        for (int i = 0; i < emergency.length; i++) {
			for (int j = 0; j < emergency.length; j++) {
				if(emergency[i] <= emergency[j]) {
					answer[i]++;
				}
			}
		}
        
        return answer;
    }

}
