package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_외계어사전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int s = Integer.parseInt(br.readLine());

		String[] spell = new String[s];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < spell.length; i++) {
			spell[i] = st.nextToken();
		}

		int d = Integer.parseInt(br.readLine());

		String[] dic = new String[d];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < dic.length; i++) {
			dic[i] = st.nextToken();
		}

		int result = solution(spell, dic);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}

	public static int solution(String[] spell, String[] dic) {
        int answer = 2;
        
        for (int i = 0; i < dic.length; i++) {
            for (String s : spell) {
                if(dic[i].contains(s)) {
                    answer = 1;
                } else {
                    answer = 2;
                    break;
                }
            }

            if(answer == 1) {
                break;
            }
        }
//        
//        for(int i=0;i<dic.length;i++){
//            int answer = 2;
//            for(int j=0;j<spell.length;j++){
//                if(dic[i].contains(spell[j])) answer ++;
//            }
//            if(answer==spell.length) {
//            	answer = 1;
//            }
        
        return answer;
    }

}
