package boj.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

  public static void main(String[] args) throws IOException {
    /*
    * 팩토리얼 0의 개수
    * N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
    *
    * 입력
    * 첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)
    * 
    * 출력
    * 첫째 줄에 구한 0의 개수를 출력한다
    * 
    * 예제 입력   예제 출력
    * 10         2
    * */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int count = 0;

    while (n >= 5) {
        count += n / 5;
        n /= 5;
    }

    System.out.println(count);
  }

  /*
   * 문제 레벨 : 실버 5
   * 제한 시간 : 20분
   * 걸린 시간 : 10분
   * 해결 과정 : 처음에 주어진 N을 가지고 팩토리얼을 계산해야 하는 것인가 생각했는데, n의 값이 조금만 숫자가 커져도 변수에 값을 담을 수 없다는 것을 알았음.
   * 0의 갯수를 구하기 위해서는 무조건 숫자가 5 이상이어야 하기 때문에 n의 값이 5 이상일 경우의 조건을 달았고,
   * 2, 5로 나누었을 때 끝의 자리가 0이 나오지만, 팩토리얼에 2가 5보다 항상 많기 때문에 n의 값이 5로 나누어질 때까지 나누면서
   * 몫을 count에 저장하는 방식으로 구현.
   * 어려웠던 점(아쉬운 점) : 없었다.
   * */
}
