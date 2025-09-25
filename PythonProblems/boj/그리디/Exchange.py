# 문제 : 거스름돈
# 타로는 자주 JOI잡화점에서 물건을 산다. 
# JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 언제나 거스름돈 개수가 가장 적게 잔돈을 준다. 
# 타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오.

# 입력
# 입력은 한줄로 이루어져있고, 타로가 지불할 돈 (1 이상 1000미만의 정수) 1개가 쓰여져있다.

# 출력
# 제출할 출력 파일은 1행으로만 되어 있다. 잔돈에 포함된 매수를 출력하시오.

# 문제 풀이(직접한 내용)
t = int(input())
myyen = 1000

while myyen > 0:
    a = t // 500
    myyen = myyen - (a * 500)
    t %= 500
    b = t // 100
    myyen = myyen - (b * 100)
    t %= 100
    c = t // 50
    myyen = myyen - (c * 50)
    t %= 50
    d = t // 10
    myyen = myyen - (d * 10)
    t %= 10
    e = t // 5
    myyen = myyen - (e * 5)
    t %= 5
    f = t // 1
    t %= 1
    myyen = myyen - (f * 1)
    result = a + b + c + d + e + f
    print(result)

# 답안
price = int(input())
change = 1000 - price

coins = [500, 100, 50, 10, 5, 1]
cnt = 0
for coin in coins:
    cnt += change // coin
    change %= coin

print(cnt)

# 답안 2
t = int(input())        # 물건 가격
change = 1000 - t       # 거스름돈

a = change // 500
change -= a * 500

b = change // 100
change -= b * 100

c = change // 50
change -= c * 50

d = change // 10
change -= d * 10

e = change // 5
change -= e * 5

f = change // 1
change -= f * 1

result = a + b + c + d + e + f
print(result)
