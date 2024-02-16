package level1.week2;

import java.util.Scanner;

public class PG_level1_직사각형별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a * b; i++) {
            if(i % a == 0 && i != 0) {
                sb.append("\n");
            }
            sb.append("*");
        }

        System.out.println(sb);
    }

}
