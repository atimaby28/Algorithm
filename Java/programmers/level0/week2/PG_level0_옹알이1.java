package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_옹알이1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		String[] babbling = new String[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < babbling.length; i++) {
			babbling[i] = st.nextToken();
		}
		
		int result = solution(babbling);
		
		bw.write(result + " ");
		
		bw.flush();
		bw.close();
		
	}
	
    public static int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
        	babbling[i] = babbling[i].replaceAll("aya", "*");
        	babbling[i] = babbling[i].replaceAll("ye", "*");
        	babbling[i] = babbling[i].replaceAll("woo", "*");
        	babbling[i] = babbling[i].replaceAll("ma", "*");
		}
        
        for (int i = 0; i < babbling.length; i++) {
        	babbling[i] = babbling[i].replaceAll("[\\*]", "");
		}
        
        for (int i = 0; i < babbling.length; i++) {
			if(babbling[i].isEmpty()) {
				answer++;
			}
		}
        
        return answer;
    }

}
