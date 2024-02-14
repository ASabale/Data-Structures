package tree;

public class AVLtreeTest {
    public static void main(String[] args) {
        AVLtree tree = new AVLtree();
        //10
        //  20
        //    30
        tree.insert(30);
        tree.insert(20);
        tree.insert(10);
    }
}
