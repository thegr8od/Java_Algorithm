import sys

input = sys.stdin.readline
n, m = map(int, input().split())
arr = list(map(int, input().split()))

sum_lst = [0]
total = 0
for i in range(len(arr)):
    total += arr[i]
    sum_lst.append(total)


for i in range(m):
    i, j = map(int,input().split())
    print(sum_lst[j]-sum_lst[i - 1])
