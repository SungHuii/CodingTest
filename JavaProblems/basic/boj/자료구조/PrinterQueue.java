package boj.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue {

  public static void main(String[] args) throws IOException {
    /*
    * 프린터 큐
    * 실버 3 / 시간 제한 2초 / 메모리 제한 128MB
    * 문제
    * 여러분도 알다시피 여러분의 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다.
    * 여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다.
    * 하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.
    * 1. 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
    * 2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
    * 예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.
    * 여러분이 할 일은, 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다.
    * 예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.
    *
    * 입력
    * 첫 줄에 테스트케이스의 수가 주어진다. 각 테스트케이스는 두 줄로 이루어져 있다.
    * 테스트케이스의 첫 번째 줄에는 문서의 개수 N(1 ≤ N ≤ 100)과, 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)이 주어진다.
    * 이때 맨 왼쪽은 0번째라고 하자. 두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다.
    * 중요도는 1 이상 9 이하의 정수이고, 중요도가 같은 문서가 여러 개 있을 수도 있다.
    *
    * 출력
    * 각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력한다.
    * */

    /*
    * 내 풀이 생각
    * 테스트케이스의 문서의 개수 N 만큼 for 문으로 queue 에 add로 붙여준다. (n길이의 queue 생성)
    * 이 때, add()의 값은 for문의 i값이 아닌, 중요도를 넣어줘야 한다.
    * 그리고, m의 값의 위치?를 어떤 변수(k라고 가정)에 지정을 해놓은 뒤,
    * 현재 queue의 첫번째(0번째)값이 queue 내부를 훑었을 때 0번째 값보다 큰 값이 있다면 queue.offer(queue.poll());을 한다?
    * 그리고 count 변수를 만들어서 출력이 될때마다 +1을 시켜주다가,
    * k가 출력되는 순간 count 값을 실제 출력으로 리턴한다.
    * */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

    StringBuilder sb = new StringBuilder();

    // 테스트 케이스 개수만큼 반복
    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken()); // 문서의 개수
      int m = Integer.parseInt(st.nextToken()); // 몇 번째로 인쇄되었는지 궁금한 문서의 위치(0~n-1)

      st = new StringTokenizer(br.readLine());
      Queue<int[]> queue = new LinkedList<>(); // Queue를 {순서, 중요도}로 넣기 위해 int[] 배열을 사용함

      // 큐에 모든 문서 넣기
      for (int j = 0; j < n; j++) { // 문서의 개수만큼 반복
        int priority = Integer.parseInt(st.nextToken()); // 중요도
        queue.add(new int[]{j, priority}); // {순서, 중요도}로 넣기
      }

      int count = 0; // 인쇄된 횟수 누적
      while (!queue.isEmpty()) { // 큐가 비어있지 않을 때까지 반복
        int[] current = queue.poll(); // queue의 현재 값 빼기
        boolean canPrint = true; // 현재 문서가 가장 높은 중요도인지(인쇄 가능한지) 판단

        // 현재 문서보다 중요도가 높은 문서가 있는지 확인
        for (int[] others : queue) {
          if (others[1] > current[1]) { // 1번 인덱스가 중요도니까 1번 인덱스를 비교
            canPrint = false; // 다른 문서가 더 높은 중요도임.
            break;
          }
        }

        if (canPrint) {
          // 현재 문서가 가장 높은 중요도라면 인쇄
          count++; // 인쇄 횟수 증가
          if (current[0] == m) { // 인쇄한 문서의 초기 위치가 찾으려는 m과 같을 때
            sb.append(count).append('\n');
            break;
          }
        } else {
          // 중요도가 더 높은 문서가 있다면 뒤로 보냄
          queue.offer(current);
        }
      }
    }
    System.out.println(sb);
  }
  /*
   * 제한 시간 : 20분
   * 걸린 시간 : 20분 초과. (AI 도움을 받아 해결)
   * 시간 복잡도 : O(n^2) (중첩된 for문)
   * - 테스트 케이스 T 만큼 반복.
   * - 각 테스트 케이스 내부에서 문서의 갯수 N을 큐에 넣기 -> O(N)
   * - 인쇄 로직에서 문서 하나를 인쇄하기 위해 큐에 있는 나머지 문서를 확인할 때 for문 사용 -> O(N)
   * - 이중 루프 형태로 O(N^2)의 복잡도.
   *
   * 해결 과정 및 피드백
   * 1. 큐에 저장하는 데이터 구조 변경
   *    - 초기 생각: 중요도만 큐에 저장하려고 했음.
   *    - 문제점: 중요도가 같은 문서가 있을 때, 내가 찾는 문서(M번째)인지 구별할 수 없음.
   *    - 해결: int[] {초기위치, 중요도} 형태의 배열을 큐에 저장하여, 문서의 고유 위치와 중요도를 함께 관리함.
   *
   * 2. M의 위치 추적 방식 개선
   *    - 초기 생각: 별도의 변수 k를 만들어 M의 위치가 바뀔 때마다 추적하려고 했음.
   *    - 해결: 문서 객체(배열) 자체에 '초기 위치' 정보를 담아두었기 때문에, 별도로 위치를 추적할 필요 없이
   *           인쇄 시점에 current[0] == m 인지만 확인하면 됨.
   *
   * 3. 로직 구조 명확화
   *    - 큐 생성과 데이터 입력을 먼저 완료한 후, while문을 통해 인쇄 로직을 별도로 수행하도록 구조를 분리함.
   *    - canPrint 변수를 사용하여 '인쇄 가능 여부'를 명확히 판단하고 분기 처리함.
   */
}
