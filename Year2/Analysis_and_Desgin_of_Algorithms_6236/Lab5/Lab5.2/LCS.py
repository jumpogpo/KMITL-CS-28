def displayMatrix(matrix):
    for i in range(8):
        for j in range(7):
            print(matrix[i][j], end=" ")
        print()

def LCS(X, Y):
    matrix = [[] for _ in range(len(X) + 1)]
 
    for i in range(len(X) + 1):
        for j in range(len(Y) + 1):
            if i == 0 or j == 0:
                matrix[i].append(0)
            else:
                if Y[j - 1] == X[i - 1]:
                    matrix[i].append(matrix[i - 1][j - 1] + 1)
                else:
                    matrix[i].append(max(matrix[i - 1][j], matrix[i][j - 1]))

    return matrix

def findLCS(X, Y, matrix):
    def findLCSHelper(i, j):
        if i == 0 or j == 0:
            return [""]
        if X[i - 1] == Y[j - 1]:
            lcs = findLCSHelper(i - 1, j - 1)
            return [x + X[i - 1] for x in lcs]
        else:
            lcs = []
            if matrix[i][j] == matrix[i - 1][j]:
                lcs.extend(findLCSHelper(i - 1, j))
            if matrix[i][j] == matrix[i][j - 1]:
                lcs.extend(findLCSHelper(i, j - 1))
            return lcs

    return findLCSHelper(len(X), len(Y))

def main():
    X = input("Please enter X string: ")
    Y = input("Please enter Y string: ")

    matrix = LCS(X, Y)
    lcs_list = list(set(findLCS(X, Y, matrix)))
    
    print("\n[Matrix]")
    displayMatrix(matrix)

    print("\n[Longest Common Subsequence]")
    for i in range(len(lcs_list)):
        print(f"{i+1}) {lcs_list[i]}")

if __name__ == "__main__":
    main()