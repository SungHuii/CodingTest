package boj.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VPS {

  public static void main(String[] args) throws IOException {
    /*
    * 괄호
    * 시간 제한	메모리 제한
    * 1 초	    128 MB
    *
    * 문제
    * 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
    * 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
    * 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
    * 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다. 예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” ,
    * 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.
    * 여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.
    *
    * 입력
    * 입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다.
    * 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다.
    * 하나의 괄호 문자열의 길이는 2 이상 50 이하이다.
    *
    * 출력
    * 출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다.
    *
    * 예제 입력 1
    * 6
    * (())())
    * (((()())()
    * (()())((()))
    * ((()()(()))(((())))()
    * ()()()()(()()())()
    * (()((())()(
    *
    * 예제 출력 1
    * NO
    * NO
    * YES
    * NO
    * YES
    * NO
    * */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < t; i++) {
      String ps = br.readLine();
        if (isVPS(ps)) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      }
    System.out.println(sb);
  }

  public static boolean isVPS(String ps) {
    boolean result = false;
    int count = 0;

    for (char c : ps.toCharArray()) {
      if (c == '(') {
        count ++;
      } else if (c == ')') {
        count --;
      }

      if (count < 0) {
        return result;
      }
    }

    if (count == 0) {
      result = true;
    }

    return result;
  }

  // 스택을 이용해서 푸는 방식
  /*public static boolean isVPS(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(c); // 여는 괄호는 저장
      } else if (c == ')') {
        if (stack.isEmpty()) {
          return false; // 닫는 괄호가 나왔는데 짝이 없음
        }
        stack.pop(); // 짝을 맞춰서 제거
      }
    }

    return stack.isEmpty(); // 스택이 비어있어야 성공
  }*/

  /*
   * 문제 레벨 : 실버 4
   * 제한 시간 : 20분
   * 걸린 시간 : 18분
   * 해결 과정 : 문제의 접근법으로 count = 0을 두고, 괄호 '(' 일때 +1, ')' 일때 -1로 계산해서 합이 0이 나오는지를 판단하는 방법을 생각했음
   * 이렇게하면 괄호가 처음에 )으로 시작할 때를 예외로 두고 풀 수 있다고 생각했고, 처음에 그런식으로 구현해봤음
   * 그런데 애초에 내가 생각한 방식을 조금 다르게 생각하니 -1이 나오면 아예 내 조건이 성립이 되지 않는다는 생각을 했고, 예외 조건을 0미만일 때로 수정했음.
   * 어려웠던 점(아쉬운 점) : 문제를 풀고나서 다른 사람들의 풀이법을 보니, stack을 이용해서 푸는 방법이 정석적인 방법인 것을 확인함.
   * stack을 이용해서 풀이하는 방식도 연습.
   * */
}
