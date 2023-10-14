public class Node {
    int val;
    Node next;
 
    Node(int v) { val = v; }

    Node(int v, Node n) {
       val = v; this.next = n;
    }
 
    int getVal() { return val; }
}