package level0.week5;

import java.util.Scanner;

public class PG_level0_대소문자바꿔서출력하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        char[] charToStr = a.toCharArray();

        for (int i = 0; i < charToStr.length; i++) {
            if(a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                charToStr[i] = (char) (a.charAt(i) + 32);
            } else {
                charToStr[i] = (char) (a.charAt(i) - 32);
            }
        }
        String answer = "";

        for (char c : charToStr) {
            answer += c;
        }

        System.out.println(answer);

    }

}
