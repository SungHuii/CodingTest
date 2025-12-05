package boj.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        /*문제
    어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.
    수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 121, 12421 등은 팰린드롬수다.
    123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다.
    또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.

    입력
    입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다. 입력의 마지막 줄에는 0이 주어지며, 이 줄은 문제에 포함되지 않는다.

    출력
    각 줄마다 주어진 수가 팰린드롬수면 'yes', 아니면 'no'를 출력한다.*/

        // 효율적으로 읽기 위한 Reader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true) { // while문 시작
            String line = br.readLine(); // 한 줄씩 문자열로 입력 읽고
            // 입력이 더 이상 없거나(line == null), 문제에서 제시한 종료 값 "0"이 들어오면 반복 종료
            if (line == null || line.equals("0")) break;

            // 현재 읽은 문자열이 팰린드롬인지 여부 저장할 boolean 플래그 변수 선언
            boolean isPalindrome = true;
            // 문자열의 전체 길이
            int len = line.length();

            // 문자열 길이만큼 for문 loop
            for (int i = 0; i < len ; i++) {
                if (line.charAt(i) != line.charAt(len - 1 - i)) { // 문자열 첫글자와 반대편의 글자를 비교
                    // 하나라도 다르면 false
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    /*
    * 문제 레벨 : 브론즈 1
    * 제한 시간 : 20분
    * 걸린 시간 : 15분
    * 아쉬운 점 : 지금 생각해보면 당연하게도 끝까지 for문을 돌릴 필요가 없었지만, 막상 문제를 풀 때는 생각을 못했던 점
    * 개선 포인트 :
    * for문의 i의 범위를 len / 2까지 즉, 절반만 돌려도 앞 뒤를 전부 비교하기 때문에 굳이 전체를 for loop 돌릴 필요가 없다.
    * 시간 복잡도 : O(n) -> 팰린드롬 검사는 문자열의 앞뒤 문자를 한 번씩 비교하는 방식이기 때문에, 최대
    * 절반 길이만 탐색함. while 입력 루프는 테스트 케이스 수에 비례하기 때문
    * */
}
