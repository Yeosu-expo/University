import sys

def bfs(arr, n):
    visted = [[False for col in range(n)] for row in range(n)]
    qx = [0]
    qy = [0]
    visted[0][0] = True

    while len(qx) == 0 :
        x = qx.pop()
        y = qy.pop()

n=int(input())
arr = ["" for col in range(n)]

for i in range(n) :
    arr[i] = input()

