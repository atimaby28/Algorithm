package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PG_level0_n의배수고르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] numlist = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numlist.length; i++) {
			numlist[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = solution(n, numlist);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
	}
	
    public static int[] solution(int n, int[] numlist) {
        int[] answer = {};
        
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        
        for (int i = 0; i < numlist.length; i++) {
			if(numlist[i] % n == 0) {
				arrlist.add(numlist[i]);
			}
		}
        
        answer = new int[arrlist.size()];
        
        for (int i = 0; i < arrlist.size(); i++) {
			answer[i] = arrlist.get(i);
		}
        
        return answer;
    }

}