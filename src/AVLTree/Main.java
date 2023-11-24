package AVLTree;

public class Main {
    public static void main(String[] args){
        AVL avlTree = new AVL();
        avlTree.insert(50);
        avlTree.insert(20);
        avlTree.insert(60);
        avlTree.insert(10);
        avlTree.insert(30);
        avlTree.insert(40);

        Node root=AVL.root;

        display(root);
    }
    public static void display(Node root){
        if(root==null) return ;

        StringBuilder sb=new StringBuilder();
        if(root.left==null) sb.append(". -> ");
        else sb.append(root.left.data+" -> ");

        sb.append(root.data);

        if(root.right==null) sb.append(" <- .");
        else sb.append(" <- "+root.right.data);

        System.out.println(sb);

        display(root.left);
        display(root.right);
    }
}
