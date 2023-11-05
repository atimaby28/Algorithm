package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_한번만등장한문자 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		
		String result = solution(s);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		
	}
	
    public static String solution(String s) {
        String answer = "";
        
        int[] check = new int[26]; 
        
        for (int i = 0; i < s.length(); i++) {
			check[s.charAt(i) - 'a']++;
		}
        
        for (int i = 0; i < check.length; i++) {
			if(check[i] == 1) {
				answer += (char)(i + 'a');
			}
		}
        
        return answer;
    }

}
