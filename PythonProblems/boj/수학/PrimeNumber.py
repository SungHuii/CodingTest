# 문제
# 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

# 입력
# 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

# 출력
# 주어진 수들 중 소수의 개수를 출력한다.

# 예제 입력
# 4
# 1 3 5 7 -> 3 

# 풀이
n = int(input())
numbers = list(map(int, input().split()))
count = 0

for i in range(n):              # N개의 수를 돌면서
    i = numbers[i]              # 현재 검사할 수 i
    a = i                       # a는 i를 저장해둠
    while i > 0:                # i가 0이 될 때까지 루프
        if i < 2:               # i가 2보다 작으면
            count += 1          # 소수로 판단(?)
            continue            # 다음 while로 넘어감
        b = a / (i - 1)         # a를 (i-1)로 나눔
        if b != 0:              # 0이 아니면 소수로 판단(?)
            count += 1
        i = i - 1               # i를 줄여감


# 해설
# 입력: 첫 줄에 자연수의 개수 N
n = int(input())

# 두 번째 줄에 N개의 자연수 입력
numbers = list(map(int, input().split()))

# 소수 개수를 세는 변수
count = 0

# numbers 안에 있는 수를 하나씩 확인
for num in numbers:
    # 1 이하는 소수가 아니므로 건너뛴다
    if num < 2:
        continue

    # 소수 여부를 표시하는 플래그 (처음엔 소수라고 가정)
    is_prime = True

    # 2부터 num의 제곱근까지 나누어보며 소수 판별
    # num ~ 1까지를 모두 확인하면 불필요한 연산이 많이 발생하기 때문에 똑같은 결과이지만 더 효율적인 연산이 가능한 방식
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:   # 나누어떨어지는 약수가 있으면
            is_prime = False  # 소수가 아님
            break            # 더 확인할 필요 없음

    # 소수라면 개수 증가
    if is_prime:
        count += 1

# 최종 결과 출력
print(count)