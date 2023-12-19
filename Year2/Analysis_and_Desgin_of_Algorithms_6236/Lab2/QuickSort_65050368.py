# itemList = [12, 38, 32, 75, 16, 45, 39, 86, 23, 36]
itemList = []

while True:
    try:
        inputNum = int(input("Please input number (or enter a non-integer to stop): "))
    except ValueError:
        break

    itemList.append(inputNum)

def quicksort(arr):
    if len(arr) <= 1:
        return arr
    
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    
    return quicksort(left) + middle + quicksort(right)

print(quicksort(itemList))
