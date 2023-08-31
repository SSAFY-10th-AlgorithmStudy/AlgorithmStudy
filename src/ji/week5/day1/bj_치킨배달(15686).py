import sys

def sol():
    map_size, remain_num = map(int,input().split())
    store_list = [] # 치킨집
    house_list = [] # 일반집
    graph = []

    # 맵 세팅
    for i in range(map_size):
        row = list(map(int,input().split()))
        graph.append(row)

    for h in range(0,map_size):
        for w in range(0,map_size):
            if graph[h][w] == 2:
                store_list.append([h,w])
            if graph[h][w] == 1:
                house_list.append([h,w])
              
    # logic
    picked_store = get_comb(store_list, remain_num)
    answer = 10000
    for arr in picked_store:
        totalDis = 0 # 집 마다 최적의 치킨 거리 모음
        for a in house_list: # 일반집
            minDis = 10000
            for b in arr: # 치킨집
                newDis = cal_dist(a,b)
                if(minDis > newDis):
                    minDis = newDis

            totalDis += minDis
        if answer > totalDis:
            answer = totalDis
    print(answer)
    return answer

def get_comb(arr, n):
    result = []

    if n == 0:
        return [[]]

    for i in range(0, len(arr)):
        item = arr[i]
        temp = arr[i+1:]
        for c in get_comb(temp, n-1):
            result.append([item] + c)
    return result

def cal_dist(a,b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])

sol()
