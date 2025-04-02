def heart():
    for i in range(n):
        for j in range(n):
            if lst[i][j] == '*':
                return i,j

def left(x,y):
    cnt = 0
    for i in range(y-1,-1,-1):
        cnt +=1
        if lst[x][i] =='_':
            return cnt-1
    return cnt

def right(x,y):
    cnt = 0
    for i in range(y+1,n,1):
        cnt +=1
        if lst[x][i] == '_':
            return cnt-1
    return cnt

def waist(x,y):
    cnt=0
    for i in range(x,n):
        cnt+=1
        if lst[i][y] == '_':
            break
    return cnt-1

def leg(x,y):
    cnt=1
    for i in range(x,n):
        if lst[i][y] == '_':
            break
        cnt +=1
    return cnt-1


n = int(input())
lst = []
for _ in range(n):
    lst.append(list(input()))

x,y = heart()
print(x+2,y+1)
print(left(x+1, y), end=' ')
print(right(x+1,y), end=' ')
waist_cnt = waist(x+2,y)
print(waist_cnt, end=' ')
print(leg(x+waist_cnt+2, y-1), end=' ')
print(leg(x+waist_cnt+2, y+1), end=' ')