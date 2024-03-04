class BestFit:
    def __init__(self, items, bin_capacity):
        self.items = items
        self.bin_capacity = bin_capacity

    def best_fit(self):
        bins = [[] for _ in range(len(self.items))]
        bin_weights = [0] * len(self.items)

        for i, item in enumerate(self.items):
            best_bin = None
            min_remaining_capacity = float('inf')

            for j, bin_weight in enumerate(bin_weights):
                remaining_capacity = self.bin_capacity - bin_weight

                if remaining_capacity >= item and remaining_capacity < min_remaining_capacity:
                    best_bin = j
                    min_remaining_capacity = remaining_capacity
            
            if best_bin is not None:
                bins[best_bin].append((i + 1, item))
                bin_weights[best_bin] += item
            else:
                bins.append([(i + 1, item)])
                bin_weights.append(item)

        return bins

    def print_output(self):
        print("Best Fit")
        print(", ".join(map(str, self.items)))
        
        for i, bin_contents in enumerate(bins):
            if len(bin_contents) == 0: break

            print(f"Bin{i + 1}:", end=" ")

            for item in bin_contents:
                print(f"{item[0]}({item[1]})", end=", ")

            print()

if __name__ == "__main__":
    items = [2, 8, 1, 5, 1, 7, 1 ,2]
    bin_capacity = 10
    bestFit = BestFit(items, bin_capacity)
    bins = bestFit.best_fit()
    bestFit.print_output()
