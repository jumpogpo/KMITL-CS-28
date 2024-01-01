class Vertex:
    def __init__(self, name):
        self.name = name
        self.parent = self
        self.rank = 0

    def __str__(self):
        return f"{self.name}"

def find_set(vertex):
    if vertex != vertex.parent:
        vertex.parent = find_set(vertex.parent)
    return vertex.parent

def union_sets(vertex1, vertex2):
    root1 = find_set(vertex1)
    root2 = find_set(vertex2)

    if root1 != root2:
        if root1.rank > root2.rank:
            root2.parent = root1
        else:
            root1.parent = root2
            if root1.rank == root2.rank:
                root2.rank += 1

def kruskal(vertices, edges):
    total_cost = 0

    for edge in edges:
        start_vertex, end_vertex, weight_vertex = edge
        start_vertex = vertices[start_vertex - 1]
        end_vertex = vertices[end_vertex - 1]

        if find_set(start_vertex) != find_set(end_vertex):
            total_cost += weight_vertex
            union_sets(start_vertex, end_vertex)

    return total_cost

def get_integer_input(prompt, lower_bound=None):
    while True:
        try:
            value = int(input(prompt))
            if lower_bound is None or value >= lower_bound:
                return value
            else:
                print(f"Value must be greater than or equal to {lower_bound}")
        except ValueError:
            print("Invalid input. Please enter an integer.")

def createGraph():
    verticesAmount = get_integer_input("Please enter vertices amount: ", 1)
    edgesAmount = get_integer_input("Please enter edges amount: ", 0)

    vertices = [Vertex(str(i + 1)) for i in range(verticesAmount)]
    edges = []

    for i in range(edgesAmount):
        print(f"[Edge {i + 1}]")
        while True:
            start_vertex = get_integer_input(f"Please enter start vertex: ", 0)
            end_vertex = get_integer_input(f"Please enter end vertex: ", 0)

            if 0 < start_vertex <= len(vertices) and 0 < end_vertex <= len(vertices):
                break
            else:
                print("Invalid vertex")

        weight_vertex = get_integer_input(f"Please enter weight: ", 0)
        edges.append((start_vertex, end_vertex, weight_vertex))

    edges = sorted(edges, key=lambda x: x[2])
    return vertices, edges

def main():
    vertices, edges = createGraph()
    total_cost = kruskal(vertices, edges)
    print(f"Total Cost of Minimum Spanning Tree: {total_cost}")

if __name__ == "__main__":
    main()
