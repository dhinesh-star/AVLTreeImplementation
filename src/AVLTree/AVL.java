package AVLTree;

public class AVL {
    static Node root;
    public AVL(){
        root = null;
    }
    void insert(int val){
//        System.out.println("-------------------------------");
        root = insertIntoBST(root,val);
//        System.out.println("-------------------------------");
    }
    int getHeight(Node node){
        if(node==null) return -1;
        return node.height;
    }
    Node insertIntoBST(Node root1, int val){
        if(root1 ==null) return new Node(val);
        else if(val> root1.data){
            root1.right = insertIntoBST(root1.right,val);
        }
        else if(val< root1.data){
            root1.left = insertIntoBST(root1.left,val);
        }
        root1.height = 1 + Math.max(getHeight(root1.left),getHeight(root1.right));

        int bstFactor = getHeight(root1.left) -getHeight(root1.right);

        //LL Rotation
        if(bstFactor>1 && val< root1.left.data){
            return rightRotation(root1);
        }
        //LR Rotation
        else if(bstFactor>1 && val> root1.left.data){
            root1.left = leftRotation(root1.left);
            return rightRotation(root1);
        }
        //RR Rotation
        else if(bstFactor<-1 && val> root1.right.data){
            return leftRotation(root1);
        }
        //RL Rotation
        else if(bstFactor<-1 && val< root1.right.data){
            root1.right = rightRotation(root1.right);
            return leftRotation(root1);
        }

//        System.out.println("For value "+root1.data+"is:- "+root1.height+" "+bstFactor);
        return root1;
    }
    Node rightRotation(Node z){
        /*
                      z                                    y
                    /   \                                /   \
                   y    t4                              x     z
                  / \               =>                 / \   / \
                 x   t3                               t1  t2 t3 t4
                / \
               t1  t2
               If we node only node z, y, t3 are altered
         */
        Node y = z.left;
        Node t3 = y.right;

        z.left = t3;
        z.height = 1 + Math.max(getHeight(z.left),getHeight(z.right));
        y.right = z;
        y.height = 1 + Math.max(getHeight(y.left),getHeight(y.right));
        return y;
    }
    Node leftRotation(Node z){
        /*
                      z                              y
                    /   \                          /   \
                   t4    y                        z      x
                        / \        =>            / \    / \
                       t3  x                   t1   t2 t3 t4
                          / \
                         t2  t1
               If we node only node z, y, t3 are altered
         */
        Node y =z.right;
        Node t3 = y.left;

        z.right = t3;
        z.height = 1+Math.max(getHeight(z.left),getHeight(z.right));
        y.left = z;
        y.height = 1+Math.max(getHeight(y.left),getHeight(y.right));
        return y;
    }
}
class Node{
    int data,height;
    Node left,right;
    Node(){
        left=right=null;
        height=0;
    }
    Node(int val){
        this();
        this.data =val;
    }
}
