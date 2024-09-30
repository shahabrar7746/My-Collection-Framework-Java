package Algorithms.Traversals.BFS;

import Algorithms.Traversals.DFS.Inorder;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class LevelOrder {


    private class Node{
         private Node left,right;
         private final int data;
         Node(int data){
             this.data = data;
         }
    }
    private Node root;



    private String object;

    LevelOrder(){
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
      Queue<Node> queue = new ArrayDeque<>();
      queue.add(root);
      while(!queue.isEmpty()){
          int len = queue.size();
         while(len != 0){
             Node node = queue.poll();
             if(node.left != null){
                 queue.add(node.left);
             }if(node.right != null){
                 queue.add(node.right);
             }
             object = object + String.valueOf(node.data) + " ";
             len--;
         }
         object = object + "\n";
      }
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
        LevelOrder tree = new LevelOrder();
     int num = new Random().nextInt(90);
     while(num != 0){
         tree.put(new Random().nextInt(100)*num);
         num--;
     }

        System.out.println(tree);
    }

}
