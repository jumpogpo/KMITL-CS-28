class SubsetCalculator:
    def __init__(self, W, M):
        self.W = W
        self.M = M

    def find_subsets(self):
        N = 1 << len(self.W)
        print("ix\tx\treverseX\tSum")

        for ix in range(N):
            sum = 0

            for j in range(len(self.W)):
                if (ix >> j) & 1 == 1:
                    sum += self.W[j]

            binary = bin(ix)[2:].zfill(len(self.W))
            reversed_binary = binary[::-1]

            if sum == self.M:
                print(f"{ix}\t{binary}\t{reversed_binary}\t\t{sum}**")
            else:
                print(f"{ix}\t{binary}\t{reversed_binary}\t\t{sum}")


def main():
    W = [11, 13, 6, 8]
    M = W[1] + W[2] + W[3]

    calculator = SubsetCalculator(W, M)
    print("Student ID: 65050368")
    print(f'W: {W}')
    print(f'M: {M}\n')
    print("[Subset Calculator]")
    print("Target Sum:", M)
    calculator.find_subsets()


if __name__ == "__main__":
    main()
