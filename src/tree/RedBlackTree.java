package tree;

public class RedBlackTree {
    public enum color{RED, BLACK}
    public static class RBNode{
        Integer key = null;
        Enum<RedBlackTree.color> color;
        RBNode left;
        RBNode right;
        RBNode parent;
        public RBNode(int key) {
            this.key = key;
        }
        public RBNode(){
        }
        @Override
        public String toString() {
            return "key=" + key;
        }
    }
    RBNode NIL = new RBNode();

    RBNode root = NIL;

    public void insert(int key) {
        RBNode newNode = new RBNode(key);
        insert(NIL, newNode);
    }

    private void insert(RBNode NIL, RBNode newNode){
        RBNode traverser = this.root;
        RBNode trail = NIL;
        while (traverser != NIL){
            trail = traverser;
            if(newNode.key < traverser.key)
                traverser = traverser.left;
            else traverser = traverser.right;
        }
        newNode.parent=trail;
        if (trail == NIL)
            this.root = newNode;
        else if (newNode.key < trail.key) {
            trail.left = newNode;
        }else trail.right = newNode;
        newNode.left = NIL;
        newNode.right = NIL;
        newNode.color = color.RED;
        insertFixup(NIL, newNode);
    }

    private void insertFixup(RBNode NIL, RBNode node) {
        while(true){
            RBNode parent = node.parent;
            if (!(parent.color == color.RED)) break;
            RBNode grandParent = parent.parent;
            if(parent == grandParent.left){
                RBNode uncle = grandParent.right;
                if(uncle.color==color.RED){
                    parent.color = color.BLACK;
                    uncle.color = color.BLACK;
                    grandParent.color = color.RED;
                    node = grandParent;
                }else{
                    if(node == parent.right){
                        node = parent;
                        leftRotation(node, NIL);
                    }
                    parent.color=color.BLACK;
                    grandParent.color=color.RED;
                    rightRotation(grandParent, NIL);
                }
            }else{
                RBNode uncle = grandParent.left;
                if(uncle.color==color.RED){
                    parent.color = color.BLACK;
                    uncle.color = color.BLACK;
                    grandParent.color = color.RED;
                    node = grandParent;
                }else{
                    if(node == parent.left){
                        node = parent;
                        rightRotation(node, NIL);
                    }
                    parent.color = color.BLACK;
                    grandParent.color = color.RED;
                    leftRotation(grandParent, NIL);
                }
            }
        }
        this.root.color = color.BLACK;
    }

    private void rightRotation(RBNode node, RBNode NIL) {
        RBNode leftChild = node.left;
        node.left = leftChild.right;
        if(leftChild.right != NIL){
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if(node.parent==NIL)
            this.root = leftChild;
        else if(node == node.parent.right)
            node.parent.right = leftChild;
        else node.parent.left = leftChild;
        leftChild.left = node;
        node.parent = leftChild;
    }

    private void leftRotation(RBNode node, RBNode NIL) {
        RBNode rightChild = node.right;
        node.right = rightChild.left;
        if(rightChild.left != NIL){
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if(node.parent==NIL)
            this.root = rightChild;
        else if (node == node.parent.left)
            node.parent.left = rightChild;
        else node.parent.right = rightChild;
        rightChild.left = node;
        node.parent = rightChild;
    }

    public void inOrder() {
        if(this.root==this.NIL){
            System.out.println("tree is empty");
            return;
        }
        inOrder(this.root);
        System.out.println();
    }

    private void inOrder(RBNode node){
        if(node == this.NIL){
            return;
        }
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    public void preOrder() {
        if(this.root==this.NIL){
            System.out.println("tree is empty");
            return;
        }
        preOrder(this.root);
        System.out.println();
    }

    private void preOrder(RBNode node){
        if(node == this.NIL){
            return;
        }
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        if(this.root==this.NIL){
            System.out.println("tree is empty");
            return;
        }
        postOrder(this.root);
        System.out.println();
    }

    private void postOrder(RBNode node){
        if(node == this.NIL){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key + " ");
    }


    public void top(){
        if(this.root==this.NIL){
            System.out.println("empty tree");
        }else{
            System.out.print(this.root.key);
        }
        System.out.println();
    }

    public void delete(int key) {
        RBNode node = search(key);
        if(node==this.NIL)
            return;
        delete(node);
    }

    public Boolean isPresent(int key){
        RBNode node = search(key);
        return node != this.NIL;
    }

    private RBNode search(int key) {
        RBNode node = this.root;
        while(node!=this.NIL){
            if(node.key==key)
                break;
            else if(node.key<key)
                node = node.left;
            else node = node.right;
        }
        return node;
    }

    private void delete(RBNode nodeTodelete){
        RBNode node = nodeTodelete;
        Enum<color> nodeOriginalColor = node.color;
        RBNode child;
        if(nodeTodelete.left==this.NIL){
            child = nodeTodelete.right;
            RBTransplant(nodeTodelete, child);
        } else if (nodeTodelete.right == this.NIL) {
            child = nodeTodelete.left;
            RBTransplant(nodeTodelete, child);
        }else {
            node = Minimum(nodeTodelete.right);
            nodeOriginalColor = node.color;
            child = node.right;
            if(node!=nodeTodelete.right){
                RBTransplant(node, node.right);
                node.right = nodeTodelete.right;
                node.right.parent = node;
            }else child.parent = node;
            RBTransplant(nodeTodelete, node);
            node.left = nodeTodelete.left;
            node.left.parent = node;
            node.color = nodeTodelete.color;
        }
        if (nodeOriginalColor == color.BLACK)
            deleteFixup(child);
    }

    private void deleteFixup(RBNode nodeTofix){
        while(nodeTofix != this.root && nodeTofix.color == color.BLACK){
            if (nodeTofix == nodeTofix.parent.left){
                RBNode sibling = nodeTofix.parent.right;
                if (sibling.color==color.RED){
                    sibling.color = color.BLACK;
                    nodeTofix.parent.color = color.RED;
                    leftRotation(nodeTofix.parent, this.NIL);
                    sibling = nodeTofix.parent.right;
                }
                if (sibling.left.color == color.BLACK && sibling.right.color == color.BLACK){
                    sibling.color = color.RED ;
                    nodeTofix = nodeTofix.parent;
                }else{
                    if(sibling.right.color == color.BLACK){
                        sibling.left.color = color.BLACK;
                        sibling.color = color.RED;
                        rightRotation(sibling, this.NIL);
                        sibling = nodeTofix.parent.right;
                    }
                    sibling.color = nodeTofix.parent.color;
                    nodeTofix.parent.color = color.BLACK;
                    sibling.right.color = color.BLACK;
                    leftRotation(nodeTofix.parent, this.NIL);
                    nodeTofix = this.root;
                }
            }else{
                RBNode sibling = nodeTofix.parent.left;
                if(sibling.color == color.RED){
                    sibling.color = color.BLACK;
                    nodeTofix.parent.color = color.RED;
                    rightRotation(nodeTofix.parent, this.NIL);
                }
                if(sibling.right.color == color.BLACK && sibling.left.color == color.BLACK){
                    sibling.color = color.RED;
                    nodeTofix = nodeTofix.parent;
                }else{
                    if(sibling.left.color == color.BLACK){
                        sibling.right.color = color.BLACK;
                        sibling.color = color.RED;
                        leftRotation(sibling, this.NIL);
                    }
                    sibling.color = nodeTofix.parent.color;
                    nodeTofix.parent.color = color.BLACK;
                    sibling.left.color = color.BLACK;
                    rightRotation(nodeTofix.parent, this.NIL);
                    nodeTofix = this.root;
                }
            }
        }
        nodeTofix.color = color.BLACK;
    }

    private void RBTransplant(RBNode node, RBNode child) {
        if(node.parent==this.NIL)
            this.root=child;
        else if(node == node.parent.left)
            node.parent.left = child;
        else node.parent.right = child;
        child.parent = node.parent;
    }

    private RBNode Minimum(RBNode node) {
        while (node.left != this.NIL){
            node = node.left;
        }
        return node;
    }

}



