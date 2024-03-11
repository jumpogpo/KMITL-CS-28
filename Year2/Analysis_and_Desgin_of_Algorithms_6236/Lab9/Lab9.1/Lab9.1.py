class FirstFit:
    def __init__(self, items, bin_capacity):
        self.items = items
        self.bin_capacity = bin_capacity

    def first_fit(self):
        bins = [[] for _ in range(len(self.items))]
        bin_weights = [0] * len(self.items)

        for i, item in enumerate(self.items):
            bin_found = False
            for j, bin_weight in enumerate(bin_weights):
                if bin_weight + item <= bin_capacity:
                    bins[j].append((i + 1, item))
                    bin_weights[j] += item
                    bin_found = True
                    break
            if not bin_found:
                bins.append([(i + 1, item)])
                bin_weights.append(item)

        return bins

    def print_output(self):
        print("First Fit")
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
    firstFit = FirstFit(items, bin_capacity)
    bins = firstFit.first_fit()
    firstFit.print_output()