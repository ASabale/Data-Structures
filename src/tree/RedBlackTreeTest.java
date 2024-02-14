package tree;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree rb = new RedBlackTree();

        rb.insert(1);
        rb.insert(2);
        rb.insert(3);
        rb.insert(4);
        rb.insert(5);
        rb.insert(7);
        rb.insert(6);
        rb.insert(8);
        rb.insert(9);
        rb.insert(10);
        rb.inOrder();
        rb.preOrder();
        rb.postOrder();
        rb.top();
        rb.delete(4);
        System.out.println(rb.isPresent(4));
        rb.inOrder();
        rb.preOrder();
        rb.postOrder();
        rb.top();
    }
}
