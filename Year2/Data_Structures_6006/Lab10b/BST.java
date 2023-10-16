import code.TreeNode;

public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public void insert(int e) {
        if (root == null) {
            root = new TreeNode(e);
        } else {
            TreeNode curr = root;
            while (curr != null) {
                if (e < curr.val) {
                    if (curr.left != null) {
                        curr = curr.left;
                    } else {
                        curr.left = new TreeNode(e);
                        curr.left.parent = curr;
                        return;
                    }
                } else {
                    if (curr.right != null) {
                        curr = curr.right;
                    } else {
                        curr.right = new TreeNode(e);
                        curr.right.parent = curr;
                        return;
                    }
                }
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
    }

    public void printPreOrderRecurse(TreeNode root) {
        if (root == null) {
            return;
        }
        printPreOrderRecurse(root.left);
        System.out.print(root.val + " ");
        printPreOrderRecurse(root.right);
    }

    public void printInOrder() {
        printInOrderRecurse(root);
    }

    public void printInOrderRecurse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printInOrderRecurse(root.left);
        printInOrderRecurse(root.right);
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
    }

    public void printPostOrderRecurse(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostOrderRecurse(root.left);
        printPostOrderRecurse(root.right);
        System.out.print(root.val + " ");
    }

    public TreeNode search(int e) {
        return searchRecurse(root, e);
    }

    public TreeNode searchRecurse(TreeNode root, int e) {
        if (root == null) {
            return null;
        }
        if (root.val == e) {
            return root;
        }

        if (e < root.val) {
            return searchRecurse(root.left, e);
        } else {
            return searchRecurse(root.right, e);
        }
    }

    public TreeNode searchIter(int key) {
        TreeNode curr = root;
        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    return null;
                }
            } else {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    return null;
                }
            }
            if (curr.val == key) {
                return curr;
            }

            if (curr.right == null && curr.left == null) {
                break;
            }
        }
        return null;
    }

    public int height() {
        return root == null ? 0 : height(root);
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;

        /*
         * Code 9
         */

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public TreeNode findMaxFrom(TreeNode findMaxFrom) {
        /*
         * Code 10
         */

        TreeNode current = findMaxFrom;

        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    public void delete(int d, TreeNode current) {
        if (current == null)
            return; // not found

        if (d < current.val)
            delete(d, current.left);
        else if (d > current.val)
            delete(d, current.right);
        else { // found ... time to delete
            if (current.left == null || current.right == null) { // 0 or 1 child
                TreeNode q = (current.left == null) ? current.right : current.left;
                if (current.parent.left == current)
                    current.parent.left = q; // this node is left child
                else
                    current.parent.right = q;

                if (q != null)
                    q.parent = current.parent;
            } else { // two children
                    TreeNode w = findMaxFrom(current.left);
                    /*
                     * Code 11
                     */

                    current.val = w.val;
                    delete(w.val, current.left);
            } // two children
        } // found
    }

    public void delete(int e) {
        delete(e, root);
    }
}