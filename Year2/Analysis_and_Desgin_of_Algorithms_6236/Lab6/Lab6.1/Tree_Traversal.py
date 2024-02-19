class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

    def inOrder(self):
        return (self.left.inOrder() if self.left is not None else '') + self.val + ' ' + (self.right.inOrder() if self.right is not None else '')

    def preOrder(self):
        return self.val + ' ' + (self.left.preOrder() if self.left is not None else '') + (self.right.preOrder() if self.right is not None else '')
    
    def postOrder(self):
        return (self.left.postOrder() if self.left is not None else '') + (self.right.postOrder() if self.right is not None else '') + self.val + ' '
    
if __name__ == '__main__':
    root = TreeNode('T')

    root.left = TreeNode('H')
    root.right = TreeNode('A')

    root.left.left = TreeNode('N')
    root.left.right = TreeNode('A')

    root.right.left = TreeNode('P')
    root.right.right = TreeNode('A')

    root.left.left.left = TreeNode('T')
    root.left.left.right = TreeNode('K')

    print(f'In-order: {root.inOrder()}')
    print(f'Pre-order: {root.preOrder()}')
    print(f'Post-order: {root.postOrder()}')