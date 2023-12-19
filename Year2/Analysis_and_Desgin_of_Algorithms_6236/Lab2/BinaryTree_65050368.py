class Node:
    def __init__(self, value, parentNode, leftNode, rightNode):
        self.parent = parentNode
        self.left = leftNode
        self.right = rightNode
        self.value = value

def findMax(node):
    current = node
    while current.right is not None:
        current = current.right
    return current.value

def findMin(node):
    current = node
    while current.left is not None:
        current = current.left
    return current.value

itemList = [12, 38, 32, 75, 16, 45, 39, 86, 23, 36]
rootNode = Node(itemList[0], None, None, None)

for i in range(1, len(itemList)):    
    current = rootNode

    while True:
        if itemList[i] < current.value:
            if current.left is None:
                current.left = Node(itemList[i], current, None, None)
                break
            else:
                current = current.left
        else:
            if current.right is None:
                current.right = Node(itemList[i], current, None, None)
                break
            else:
                current = current.right

print(f"Min: {findMin(rootNode)}")
print(f"Max: {findMax(rootNode)}")