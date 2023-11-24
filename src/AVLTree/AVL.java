package AVLTree;

public class AVL {
    static Node root;
    public AVL(){
        root = null;
    }
    void insert(int val){
        System.out.println("-------------------------------");
        root = insertIntoBST(root,val);
        System.out.println("-------------------------------");
    }
    int getHeight(Node node){
        if(node==null) return -1;
        return node.height;
    }
    Node insertIntoBST(Node root, int val){
        if(root==null) return new Node(val);
        else if(val>root.data){
            root.right = insertIntoBST(root.right,val);
        }
        else if(val<root.data){
            root.left = insertIntoBST(root.left,val);
        }
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));

        System.out.println("For value "+root.data+"is:- "+root.height);

        int bstFactor = getHeight(root.left) -getHeight(root.right);

        System.out.println("For value "+root.data+"is:- "+root.height+" "+bstFactor);
        return root;
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
