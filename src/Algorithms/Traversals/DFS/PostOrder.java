package Algorithms.Traversals.DFS;

public class PostOrder {
    private class Node{
         private Node left,right;
         private final int data;
         Node(int data){
             this.data = data;
         }
    }
    private Node root;



    private String object;

    PostOrder(){
        object = "";
    }

    public void put(int data){
object = "";
    root =    put(data,root);
    }

    public String toString(){
        Traverse(root);

        return object;
    }
    private void Traverse(Node root){
        if(root == null){

            return;
        }
        Traverse(root.left);


        Traverse(root.right);
        object = object + String.valueOf(root.data) + " ";
    }
    public Node put(int data,Node node){
        if(node == null){

            return new Node(data);
        }
        if(node.data < data){
            node.right = put(data,node.right);
        }else{
            node.left = put(data,node.left);
        }
        return node;
    }

    public static void main(String[] args) {
        PostOrder tree = new PostOrder();
        tree.put(90);
        tree.put(56);
        tree.put(100);
        System.out.println(tree);
    }



}
