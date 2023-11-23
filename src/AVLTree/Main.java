package AVLTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AVL avlTree = new AVL();
        System.out.print("Enter the number of node to be added:- ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("Enter the val to be added in AVL Tree:- ");
            int val = sc.nextInt();
            avlTree.insert(val);
        }
//        avlTree.insert(50);
//        avlTree.insert(20);
//        avlTree.insert(60);
//        avlTree.insert(10);
//        avlTree.insert(30);
//        avlTree.insert(40);

        Node root=AVL.root;

        display(root);
    }
    //Function to display the tree
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
