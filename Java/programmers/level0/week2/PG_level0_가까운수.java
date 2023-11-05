package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_가까운수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int k = Integer.parseInt(br.readLine());
		
		int[] array = new int[k];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int n = Integer.parseInt(br.readLine());
		
		int result = solution(array, n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int[] array, int n) {
        int answer = 0;
        
        int[] diff = new int[array.length];
        
        Arrays.sort(array);
        
        for (int i = 0; i < array.length; i++) {
			diff[i] = Math.abs(array[i] - n);
		}
        
        int min = 100;
        for (int i = 0; i < diff.length; i++) {
			if(min > diff[i]) {
				min = diff[i];
				answer = array[i];
			}
		}
        
        return answer;
    }

}
