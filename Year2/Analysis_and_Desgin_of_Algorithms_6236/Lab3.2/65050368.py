def get_integer_input(prompt):
    while True:
        try:
            value = int(input(prompt))
            return value
        except ValueError:
            print("Invalid input. Please enter an integer.")

def sort_lists_descending(profitList, weightList, pwList):
    sorted_indices = sorted(range(len(pwList)), key=lambda k: pwList[k], reverse=True)
    return (
        [profitList[i] for i in sorted_indices],
        [weightList[i] for i in sorted_indices],
        [pwList[i] for i in sorted_indices]
    )

def knapsack_algorithm(sorted_profitList, sorted_weightList, capacity):
    resultProfit = 0
    for pickIndex in range(len(sorted_profitList)):
        if sorted_weightList[pickIndex] <= capacity:
            resultProfit += sorted_profitList[pickIndex]
            capacity -= sorted_weightList[pickIndex]
        else:
            resultProfit += (capacity / sorted_weightList[pickIndex]) * sorted_profitList[pickIndex]
            break
    return round(resultProfit, 2)

def main():
    itemAmount = get_integer_input("Please enter amount of item: ")
    capacity = get_integer_input("Please enter amount of capacity: ")

    profitList = []
    weightList = []

    for i in range(1, itemAmount + 1):
        profitInput = get_integer_input(f"Please enter profit for item {i}: ")
        weightInput = get_integer_input(f"Please enter weight for item {i}: ")
        profitList.append(profitInput)
        weightList.append(weightInput)

    pwList = [profit / weight for profit, weight in zip(profitList, weightList)]
    sorted_profitList, sorted_weightList, sorted_pwList = sort_lists_descending(profitList, weightList, pwList)
    result_profit = knapsack_algorithm(sorted_profitList, sorted_weightList, capacity)
    print("Result of Knapsack Algorithm is:", result_profit)

if __name__ == "__main__":
    main()
