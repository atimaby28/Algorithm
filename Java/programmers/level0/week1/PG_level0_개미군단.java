package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_개미군단 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int hp = Integer.parseInt(br.readLine());
		
		int result = solution(hp);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
	}
	
    public static int solution(int hp) {
        int answer = 0;
        
    	answer += (hp / 5);
    	
    	hp -= ((hp  / 5 ) * 5);

    	answer += (hp / 3);
    	
    	hp -= ((hp  / 3 ) * 3);
   
    	answer += hp;
    	
//        answer = hp / 5;
//        hp %= 5;
//
//        answer += hp / 3;
//        hp %= 3;
//
//        answer += hp / 1;
        
        return answer;
    }

}