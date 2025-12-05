package boj.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sorted2 {
    public static void main(String[] args) throws IOException {
        /*문제
        N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

        입력
        첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다.
        이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

        출력
        첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 성능을 위해서 추가

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int line = Integer.parseInt(br.readLine());
            arr[i] = line;
        }
        Arrays.sort(arr);
        /*for (int i : arr) {
            System.out.println(i);
        }*/

        for (int i : arr ) {
            sb.append(i).append('\n'); // 줄바꿈까지 포함해서 append로 sb에 모으기
        }
        System.out.println(sb); // 한번에 출력 (빠르게 출력 됨)

        /*
         * 문제 레벨 : 실버 5
         * 제한 시간 : 20분
         * 걸린 시간 : 17분
         * 해결 과정 : 문제 해결법 자체는 무난하게 해결했고, 시간 제한 2초에서 걸려서 좀 당황했음. 출력 성능을 향상하기 위한 SB를 사용함.
         * 어려웠던 점(아쉬운 점) : 첫 실버 문제치고 난이도가 쉬워보여서 잘 푸나 싶었는데, 시간 초과가 뜨는 걸 보고 처음에 당황했음.
         * 성능이 굳이 중요하지 않아도 습관적으로 bufferedReader, StringBuilder를 사용하는 습관을 들여야할 것 같음.
         * 개선 포인트 : 출력 성능을 위한 SB 사용!
         * */
    }
}
