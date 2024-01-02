package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_A로B만들기 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 String before = br.readLine();
		 String after = br.readLine();

		 int result = solution(before, after);
		 
		 bw.write(result + "\n");
		 
		 bw.flush();
		 bw.close();
	}
	
    public static int solution(String before, String after) {
        int answer = 1;
        
        int[] check = new int[26];
        
        for (int i = 0; i < before.length(); i++) {
			check[before.charAt(i) - 'a'] += 1;
			check[after.charAt(i) - 'a'] -= 1;
		}
        
        for (int i = 0; i < check.length; i++) {
			if(check[i] != 0) {
				answer = 0;
			}
		}
        
        return answer;
    }

}
