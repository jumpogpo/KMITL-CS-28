class FFD:
    def __init__(self, items, bin_capacity):
        self.items = items
        self.bin_capacity = bin_capacity

    def first_fit_decreasing(self):
        sorted_items = sorted(enumerate(self.items, 1), key=lambda x: x[1], reverse=True)
        bins = [[] for _ in range(len(self.items))]
        bin_weights = [0] * len(self.items)

        for item_idx, item in sorted_items:
            bin_found = False
            for j, bin_weight in enumerate(bin_weights):
                if bin_weight + item <= bin_capacity:
                    bins[j].append((item_idx, item))
                    bin_weights[j] += item
                    bin_found = True
                    break
            if not bin_found:
                bins.append([(item_idx, item)])
                bin_weights.append(item)

        return bins

    def print_output(self):
        print("FFD (First-fit decreasing)")
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
    ffd = FFD(items, bin_capacity)
    bins = ffd.first_fit_decreasing()
    ffd.print_output()