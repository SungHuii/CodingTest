package chatgpt;

public class Reverse {
    public static void main(String[] args) {
        // 예시) 입력: "I love Java"  → 출력: "I evol avaJ"
        String s1 = "I love Java";
        System.out.println(reverseWordsKeepOrder(s1));

        // 공백 여러 개가 포함된 경우도 고려
        String s2 = "hello   world  !";
        System.out.println(reverseWordsKeepOrder(s2));
    }

    // TODO: 공백으로 구분된 각 '단어'의 철자만 뒤집고, 단어 순서와 공백 개수는 유지하세요.
    public static String reverseWordsKeepOrder(String s) {
        // 공백으로 단어 분리
        String word[] = s.split(" ", -1); // 공백 여러 개 보존 (일반 split(" ")은 연속 공백 무시)
        String reverse[] = new String[word.length]; // 크기가 지정된 배열 준비. 배열은 무조건 크기가 지정되어야한다.
        // NullPointerException 방지
        
        for (int i = 0; i < word.length; i++) {
            // 단어가 비어 있지 않으면 뒤집기
            if (!word[i].isEmpty()) {
                char[] chars = word[i].toCharArray();
                StringBuilder sb = new StringBuilder(); // 문자열 연결을 효율적으로 만들어줌
                for (int j = chars.length - 1; j >= 0; j--) { // 글자 역순으로 조립
                    sb.append(chars[j]);
                }
                reverse[i] = sb.toString();
            } else {
                // 공백 유지
                reverse[i] = "";
            }
            
        }
        
        return String.join(" ", reverse); // 단어를 다시 합치기
    }
}