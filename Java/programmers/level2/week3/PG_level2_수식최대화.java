package level2.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PG_level2_수식최대화 {

    public static final String[] operations = {"+", "-", "*"};
    public static List<List<String>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String expression = br.readLine();

        long result = solution(expression);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static long solution(String expression) {
        long answer = 0;

        boolean[] visited = new boolean[3];
        // 연산자 우선순위 모든 경우의 수 계산
        permutation(new ArrayList<>(), operations, visited);

        // 연산자를 " "로 치환 후 split 값들을 Long 값으로 변환 후 toList
        // 연산자를 치환하는 정규식은 "-|\\*|\\+" 또는 "[+-*]"로 나타낸다.
        List<Long> numbers = Arrays.stream(expression.replaceAll("[-*+]", " ").split(" "))
                .map(Long::parseLong).collect(Collectors.toList());
        // 숫자를 공백으로 치환 후 toList
        List<String> collect = Arrays.stream(expression.replaceAll("[0-9]", "").split(""))
                .collect(Collectors.toList());

        // 우선순위 모든 경우의 수에 따른 max 연산 값
        for (List<String> strings : list) {
            answer = Math.max(answer, solve(strings, numbers, collect));
        }

        return answer;
    }

    static long solve(List<String> strings, List<Long> numbers, List<String> operations) {


        System.out.println("strings = " + strings);
        System.out.println("numbers = " + numbers);
        System.out.println("operations = " + operations);


        // 리스트에 remove 메서드를 사용하기 위해서 복사
        List<Long> numbersClone = new ArrayList<>(numbers);
        List<String> operationsClone = new ArrayList<>(operations);

        for (int i = 0; i < strings.size(); i++) {
            String operation = strings.get(i); // 현재 순위의 연산자

            for (int j = 0; j < operationsClone.size(); j++) {
                // 현재 순위의 연산자와 같은 경우
                if (operation.equals(operationsClone.get(j))) {
                    // 연산자 앞의 수와 뒤의 수를 구한뒤 연산
                    long front = numbersClone.get(j);
                    long back = numbersClone.get(j + 1);
                    long temp = calc(front, back, operation);

                    // 연산에 사용된 두수를 제거
                    numbersClone.remove(j + 1);
                    numbersClone.remove(j);

                    // 연산에 사용된 연산자 제거
                    operationsClone.remove(j);

                    // 연산된 값을 추가
                    numbersClone.add(j, temp);

                    // 연산이 진행되는 경우 2개 -> 1개 가되므로 리스트의 사이즈에 변경이 일어남
                    // 이를 맞추기 위해서 j를 --하여 다움 for문에서 범위를 벗어나지 않게 함
                    j--;
                }
            }
        }
        // 절대값으로 변환해서 리턴
        return Math.abs(numbersClone.get(0));
    }

    static void permutation(ArrayList<String> arrayList, String[] orders, boolean[] visited) {
        if (arrayList.size() == operations.length) {
            list.add(arrayList);
            return;
        }

        for (int i = 0; i < orders.length; i++) {
            if (!visited[i]) {
                ArrayList<String> temp = new ArrayList<>(arrayList);
                temp.add(orders[i]);
                visited[i] = true;
                permutation(temp, orders, visited);
                visited[i] = false;
            }
        }
    }

    static long calc(long one, long two, String calc) {
        switch (calc) {
            case "-":
                return one - two;
            case "+":
                return one + two;
            default:
                return one * two;
        }
    }

}
