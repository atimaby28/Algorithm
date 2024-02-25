package level1.week3;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level1_다트게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String dartResult) {
        int answer = 0;

        String[] num = dartResult.split("[A-Z#]");
        char[] cha = dartResult.toCharArray();

        Stack<Integer> stackInt = new Stack<>();
        Stack<Character> stackChar = new Stack<>();

        for(String str : num) {
            System.out.println(str);
        }

        for (int i = 0; i < num.length; i++) {
            if(!num[i].equals("")) {
                stackInt.push(Integer.parseInt(num[i]));
            }
        }
        for (int i = 0; i < cha.length; i++) {
            if(cha[i] == 'S' || cha[i] == 'D' ||cha[i] == 'T' ||cha[i] == '*' ||cha[i] == '#') {
                stackChar.push(cha[i]);
            }
        }

        while(stackChar.isEmpty() && stackInt.isEmpty()) {
            if (stackChar.peek() == 'S') {
                answer += stackInt.pop();
                stackChar.pop();
            } else if (stackChar.peek() == 'D') {
                int temp = stackInt.pop();
                answer += temp * temp;
                stackChar.pop();
            } else if (stackChar.peek() == 'T') {
                int temp = stackInt.pop();
                answer += temp * temp * temp;
                stackChar.pop();
            } else if (stackChar.peek() == '#') {
                int temp = stackInt.pop();
                answer = answer * 2 + temp;
                stackChar.pop();
            } else if (stackChar.peek() == '*') {
                int temp = stackInt.pop();
                answer += temp * temp * temp;
                stackChar.pop();
            }
        }

        System.out.println(stackInt);
        System.out.println(stackChar);


        return answer;
    }

}
