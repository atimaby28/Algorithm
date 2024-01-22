package level0.week4;

import java.util.Scanner;

public class PG_level0_문자열돌리기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        for (int i = 0; i < a.length(); i++) {
            System.out.println(a.charAt(i));
        }
    }
}
