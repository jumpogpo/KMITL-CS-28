class GraphTraversal:
    def __init__(self, l, v):
        self.nodes = {}
        self.build_graph(l, v)

    def build_graph(self, l, v):
        for i in range(len(l)):
            node = l[i]
            neighbors = list(v[i])
            self.nodes[node] = neighbors

    def adjacent_lists(self):
        for node, neighbors in graph.nodes.items():
            print(f"{node}: [ {' '.join(neighbors)} ]")

    def dfs(self, start):
        visited = {}
        result = []
        stack = [start]

        while stack:
            node = stack.pop()

            if node not in visited or not visited[node]:
                result.append(node)
                visited[node] = True

                neighbors = self.nodes.get(node, [])
                for neighbor in reversed(neighbors):
                    if neighbor not in visited or not visited[neighbor]:
                        stack.append(neighbor)

        return result

    def bfs(self, start):
        visited = {}
        result = []
        queue = [start]
        visited[start] = True

        while queue:
            current = queue.pop(0)
            result.append(current)

            neighbors = self.nodes.get(current, [])
            for neighbor in neighbors:
                if neighbor not in visited or not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True

        return result

if __name__ == "__main__":
    l = "ABCDEFGH"
    v = [
        "GFDB", "AHC", "B", "AE", "FD", "AE", "A", "B"
    ]

    graph = GraphTraversal(l, v)

    print("Adjacent Lists:")
    graph.adjacent_lists()
    print("\nDFS:", ' '.join(graph.dfs(l[0])))
    print("BFS with Queue:", ' '.join(graph.bfs(l[0])))
