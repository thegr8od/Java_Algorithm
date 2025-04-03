n = int(input())
lst = list(map(int, input().split()))
student_n = int(input())

for _ in range(student_n):
    gen, num = map(int, input().split())
    if gen == 1:
        for i in range(num - 1, n, num):
            lst[i] = 1 - lst[i]
    else:
        idx = 1
        num -= 1
        lst[num] = 1 - lst[num]  # 중심 반전
        while num - idx >= 0 and num + idx < n:
            if lst[num - idx] == lst[num + idx]:
                lst[num - idx] = 1 - lst[num - idx]
                lst[num + idx] = 1 - lst[num + idx]
                idx += 1
            else:
                break

for i in range(n):
    print(lst[i], end=' ')
    if (i + 1) % 20 == 0:
        print()
