def get_integer_input(prompt, lower_bound=None, higher_bound=None):
    while True:
        try:
            value = int(input(prompt))
            if (lower_bound is None and higher_bound is None) or (value >= lower_bound and value <= higher_bound):
                return value
            else:
                if value < lower_bound:
                    print(f"Value must be greater than or equal to {lower_bound}")
                else:
                    print(f"Value must be lower than or equal to {higher_bound}")
        except ValueError:
            print("Invalid input. Please enter an integer.")

def shortest_path(sourceIndex, weightData):
    dist = [float('inf') for i in range(len(weightData))]
    visitedData = [False for i in range(len(weightData))]
    dist[sourceIndex] = 0

    for i in range(len(weightData)):
        minimumIndex = find_minimum_distance(dist, visitedData)
        visitedData[minimumIndex] = True

        for j in range(len(weightData)):
            if visitedData[j] == False and weightData[minimumIndex][j] != 0 and dist[minimumIndex] + weightData[minimumIndex][j] < dist[j]:
                dist[j] = dist[minimumIndex] + weightData[minimumIndex][j]

    return dist
    
def find_minimum_distance(dist, visitedData):
    min = float('inf')
    currentIndex = -1

    for i in range(len(dist)):
        if visitedData[i] != True and dist[i] <= min:
            min = dist[i]
            currentIndex = i

    return currentIndex

def main():
    verticesAmount = get_integer_input("Please enter the amount of vertices: ", 1, float('inf'))
    weightData = [[] for i in range(verticesAmount)]

    for i in range(verticesAmount):
        for j in range(verticesAmount):
            if i == j:
                weightData[i].append(0)
            else:
                weight = get_integer_input(f"Please enter the weight from vertex {i+1} to vertex {j+1}: ")
                weightData[i].append(weight)

    startedVertex = get_integer_input(f"Please enter the starter vertex (1 - {verticesAmount}): ", 1, verticesAmount)
    result = shortest_path(startedVertex - 1, weightData)

    for k in range(len(result)):
        print(f"Vertex: {k + 1} Distance: {result[k]}")

if __name__ == "__main__":
    main()