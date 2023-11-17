package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_특이한정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int k = Integer.parseInt(br.readLine());
		
		int[] numlist = new int[k];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numlist.length; i++) {
			numlist[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		
		int[] result = solution(numlist, n);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
	}
	
    public static int[] solution(int[] numlist, int n) {
        int[] answer = {};
        
        int[] diff = new int[numlist.length];
        
        //Arrays.sort(numlist);
        
        for (int i = 0; i < diff.length; i++) {
			System.out.print(numlist[i] + " ");
		}
        
        System.out.println();
        
        for (int i = 0; i < numlist.length; i++) {
        	diff[i] = n - numlist[i];
		}
        Arrays.sort(diff);
        int idx = 0;
        int min = Math.abs(diff[0]);
        for (int i = 1; i < diff.length; i++) {
			if(Math.abs(diff[i]) < min) {
				min = Math.abs(diff[i]);
				idx = i;
			}
		}
        
        System.out.println(min + " " + idx);
        
        answer = new int[numlist.length];
        
        answer[0] = Math.abs(diff[idx]) + n;
        
        for (int i = 0; i < diff.length; i++) {
			System.out.print(diff[i] + " ");
		}
        System.out.println();

        
        for (int i = 0; i < diff.length; i++) {
			System.out.print(diff[i] + " ");
		}
        
        //System.out.println(idx + " " + diff[idx]);
        
//        
//        
//        answer[0] = diff[idx] + n;
        
        //System.out.println(answer[0]);
        
        return answer;
    }

}
