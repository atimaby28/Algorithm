package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_가장큰수찾기 {

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
		
		int[] result = solution(array);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
	}
	
    public static int[] solution(int[] array) {
        int[] answer = new int[2];
        
        int max = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
				index = i;
			}
		}
        
        answer[0] = max;
        answer[1] = index;
        
        return answer;
    }

}
