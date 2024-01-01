# สร้างกราฟเป็นรายการของเส้นเชื่อม (u, v, cost)
graph = [
    (0, 1, 10),
    (0, 4, 45),
    (0, 3, 30),
    (1, 2, 50),
    (1, 4, 40),
    (4, 2, 35),
    (5, 3, 20),
    (5, 1, 25),
    (5, 4, 55),
    (5, 2, 15)
]

V = set()  # เก็บโหนดทั้งหมดในกราฟ
for edge in graph:
    V.add(edge[0])  # เพิ่มโหนด u
    V.add(edge[1])  # เพิ่มโหนด v

T = set()  # เก็บเส้นเชื่อมในต้นไม้ประสาน
U = {1}  # เริ่มต้นที่โหนด 1
total_weight = 0  # เก็บผลรวมของน้ำหนักเส้นทั้งหมดในต้นไม้ประสาน

while len(U) != len(V):
    min_cost_edge = None
    min_cost = float('inf')

    for edge in graph:
        u, v, cost = edge
        if ((u in U and v not in U) or (u not in U and v in U)) and cost < min_cost:
            min_cost = cost
            min_cost_edge = (u, v)

    u, v = min_cost_edge
    T.add((u, v))
    U.add(u)
    U.add(v)

for edge in T:
    u, v = edge
    for e in graph:
        if (e[0] == u and e[1] == v) or (e[0] == v and e[1] == u):
            total_weight += e[2]
            
print("Total Weight of MST:", total_weight)