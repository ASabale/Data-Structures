package tree;

public class AVLtree {
    private static class AVLnode{
        int value;
        int height;
        AVLnode leftChild;
        AVLnode rightChild;

        public AVLnode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value="+ this.value;
        }
    }

    AVLnode root;

    public void insert(int value){
        root = insert(root, value);
    }

    private AVLnode insert(AVLnode root, int value){
        if (root==null) {
            root = new AVLnode(value);
            return root;
        }
        if(value > root.value)
            root.rightChild = insert(root.rightChild, value);
        else
            root.leftChild = insert(root.leftChild, value);

        root.height = Math.max(height(root.leftChild), height(root.rightChild))+1;

        int balanceFactor = height(root.leftChild) - height(root.rightChild);
        if(balanceFactor<-1){
            System.out.println("do leftRotation");
        } else if (balanceFactor>0) {
            System.out.println("do rightRotation");
        }
        return root;
    }

    private int height(AVLnode node){
        return (node==null) ? -1 : node.height;
    }
}
