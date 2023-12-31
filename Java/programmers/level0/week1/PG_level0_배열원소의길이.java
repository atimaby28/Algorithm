package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_배열원소의길이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		String[] strlist = new String[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < strlist.length; i++) {
			strlist[i] = st.nextToken();
		}

		int[] result = solution(strlist);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        
        for (int i = 0; i < answer.length; i++) {
			answer[i] = strlist[i].length();
		}
        
        return answer;
    }

}

