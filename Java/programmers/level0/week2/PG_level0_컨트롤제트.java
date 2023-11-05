package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class PG_level0_컨트롤제트 {
	
	public static Stack<Object> st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		
		int result = solution(s);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		
	}
	
    public static int solution(String s) {
        int answer = 0;
        
        st = new Stack<>();
        
        Object[] obj = s.split(" ");
        
        // for (String w : s.split(" ")) {
        for (int i = 0; i < obj.length; i++) {
			if (obj[i].equals("Z")) {
				st.pop();
			} else {
				st.push(obj[i]);
			}
		}

        for (Object o : st) {
        	System.out.println(o);
			answer += Integer.parseInt(String.valueOf(o));
		}
        
        return answer;
    }

}
