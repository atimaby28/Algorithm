package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_369게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int order = Integer.parseInt(br.readLine());

		int result = solution(order);
		
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		
	}
	
    public static int solution(int order) {
        int answer = 0;
        
        while(order > 0) {
        	int temp = order % 10;
        	
        	if(temp == 3 || temp == 6 || temp == 9) {
        		answer++;
        	}
        	
        	order /= 10;
        }
        
        return answer;
    }
    
//    public int solution(int order) {
//        int answer = 0;
//
//        String str = order+"";
//
//        for(int i=0; i<str.length(); i++){
//            char c = str.charAt(i);
//            if(c=='3'||c=='6'||c=='9') answer++;
//        }
//
//        return answer;
//    }

}
