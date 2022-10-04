# cook your dish here

def perfect_match(free_men, m_pref, w_pref):
    m_dict = {i + 1: 0 for i in range(n)}
    w_dict = dict()

    while (len(free_men) != 0):
        m = free_men.pop()
        pref = m_pref[m-1][m_dict[m]]
        eng = w_dict.get(pref, -1)
        if eng == -1:
            w_dict[pref] = m
        else:
            if w_pref[pref-1][w_dict[pref]-1] > w_pref[pref-1][m-1]:
                m_dict[w_dict[pref]]+=1
                free_men.add(w_dict[pref])
                w_dict[pref] = m
            else:
                free_men.add(m)
                m_dict[m] += 1
    #print(w_dict)
    sorted_tuple = sorted(w_dict.items(),key=lambda x: x[1])
    return sorted_tuple


T = int(input())
for _ in range(T):
    n = int(input())
    w_pref = []
    m_pref = []

    m_l = [0 for _ in range(n)]
    for _ in range(n):
        w_l = [0 for _ in range(n)]
        l = list(map(int, input().split()))
        for i in range(1,len(l)):
            w_l[l[i] - 1] = i

        w_pref.append(w_l)
    for _ in range(n):
        l = list(map(int, input().split()))
        m_pref.append(l[1:])

    free_men = set([i + 1 for i in range(n)])
    output = perfect_match(free_men, m_pref, w_pref)
    #print(output)

    for k,v in output:
        print(f"{v} {k}")