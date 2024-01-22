import math

class Graph:
    def __init__(self):
        self.V = 0
        self.Edges = []

    def add_edge(self, u, v, w):
        self.Edges.append([u, v, w])
        self.V = max(self.V, u, v)

def bottle_neck_path(g, distances):
    for k in range(1, g.V+1):
        for i in range(1, g.V+1):
            for j in range(1, g.V+1):
                tmp = min(distances[i][j], max(distances[i][k], distances[k][j]))
                distances[i][j] = tmp
                distances[j][i] = tmp
    return distances

def get_user_input(prompt):
    while True:
        try:
            input_value = int(input(prompt))
            return input_value
        except ValueError:
            return False

def display_matrix(matrix, step):
    print(f"Step {step}:\n")
    for i in range(1, len(matrix)):
        for j in range(1, len(matrix[i])):
            if matrix[i][j] == inf:
                print("∞", end=" ")
            else:
                print(matrix[i][j], end=" ")
        print()
    print()

def main():
    g = Graph()

    print("Please enter the edges (u v w)")

    while True:
        u = get_user_input("Please enter the starting vertex (u) for the edge (Enter -1 or letter to stop): ")
        if u == -1 or u == False:
            break

        v = get_user_input("Please enter the ending vertex (v) for the edge (Enter -1 or letter to stop): ")
        if v == -1 or u == False:
            break

        w = get_user_input("Please enter the weight (w) for the edge (Enter -1 or letter to stop): ")
        if w == -1 or u == False:
            break

        g.add_edge(u, v, w)
        print("[ Edge added ]")

    distances = [[inf for _ in range(g.V+1)] for _ in range(g.V+1)]

    for i in range(1, g.V+1):
        for j in range(1, g.V+1):
            if i == j:
                distances[i][j] = 0

    for edge in g.Edges:
        distances[edge[0]][edge[1]] = edge[2]

    print("\nBottleneck paths:")

    for k in range(g.V):
        display_matrix(distances, k)
        distances = bottle_neck_path(g, distances)

if __name__ == "__main__":
    inf = math.inf
    
    main()