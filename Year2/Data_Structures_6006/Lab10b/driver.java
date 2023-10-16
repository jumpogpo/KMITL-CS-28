public class driver {
    public static void main(String[] args) {
        demo1();
        System.out.println();
        demo4();
    }

    public static void demo1() {
        System.out.println("[Demo 1]");
        int[] data = {2, 1, 3, 4, 5, 6, 7, 8, 9};
        BST bst = new BST();
        for (int i = 0; i < data.length; i++) {
            bst.insert(data[i]);
        }
        bst.printInOrder();
        System.out.println("Tree height: " + bst.height());

        int[] data2 = {15, 20, 10, 18, 16, 12, 8, 25, 19, 30};
        BST bst2 = new BST();
        for (int j = 0; j < data2.length; j++) {
            bst2.insert(data2[j]);
        }
        bst2.printInOrder();
        System.out.println("Tree height: " + bst2.height());
        
        System.out.println();
        demo2(bst2);
    }

    public static void demo2(BST bst) {
        System.out.println("[Demo 2]");
        System.out.println("node with max value " + bst.findMaxFrom(bst.getRoot()));
        System.out.println();
        demo3(bst);
    }

    public static void demo3(BST bst) {
        System.out.println("[Demo 3]");
        bst.delete(12, bst.getRoot());
        System.out.println(bst.search(20)); // 18<-20->25
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(16)); // null<-16->null
        System.out.println(bst.search(10)); // 8<-10->null
        System.out.println(bst.search(12)); // not found
    }

    public static void demo4() {
        System.out.println("[Demo 4]");
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 30, 19, 25 };
        BST bst = new BST();
        for (int j = 0; j < dat.length; j++) {
            bst.insert(dat[j]);
        }
        bst.printInOrder();
        System.out.println();

        bst.delete(20); // default TreeNode is root
        bst.printInOrder();
        System.out.println();

        bst.delete(15); // root -> complete the delete(int, TreeNode)
        bst.printInOrder();
    }
}
