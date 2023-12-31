package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		int k = Integer.parseInt(br.readLine());
		
		int[] box = new int[k];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < box.length; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		
		int result = solution(box, n);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();

	}
	
    public static int solution(int[] box, int n) {
        int answer = 0;
        
        answer = (box[0] / n) * (box[1] / n) * (box[2] / n);
        
        return answer;
    }
}