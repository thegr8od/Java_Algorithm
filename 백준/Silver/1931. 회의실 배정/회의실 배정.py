n = int(input())
data = []
for i in range(n):
    data.append(list(map(int, input().split())))

data.sort(key =lambda x:(x[1],x[0]))

key = data[0][1]
cnt = 1
if data[0][0] == data[0][1]:
    cnt -= 1
for i in data:
    if i[0] >= key:
        key = i[1]
        cnt += 1




print(cnt)