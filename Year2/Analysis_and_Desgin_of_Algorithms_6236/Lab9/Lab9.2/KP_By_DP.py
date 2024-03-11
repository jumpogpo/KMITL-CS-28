class KP_By_DP:
    def __init__(self, n, c, P, W):
        self.n = n
        self.c = c
        self.P = P
        self.W = W

    def knapsack_dp_table(self):
        print("n:", self.n)
        print("c:", self.c)
        print("P:", self.P)
        print("W:", self.W, "\n")

        dp = [[0] * (self.c + 1) for _ in range(self.n + 1)]
        
        for i in range(1, self.n + 1):
            for j in range(1, self.c + 1):
                if self.W[i - 1] <= j:
                    dp[i][j] = max(dp[i - 1][j], P[i - 1] + dp[i - 1][j - self.W[i - 1]])
                else:
                    dp[i][j] = dp[i - 1][j]
        
        return dp

if __name__ == "__main__":
    n = 7
    c = 19
    P = [20, 8, 1, 14, 1, 16, 1]
    W = [4, 10, 6, 9, 8, 9, 8]

    kp_by_dp = KP_By_DP(n, c, P, W)
    dp_table = kp_by_dp.knapsack_dp_table()

    for row in dp_table:
        print(row)