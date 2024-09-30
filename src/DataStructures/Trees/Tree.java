package DataStructures.Trees;

import Exceptions.Stack.EmptyStackException;
import java.util.*;

public class Tree<T> {
    private  int size;

    private Node root;
    private ArrayList<String> paths;

    public Tree(){
        size = 0;
        paths = new ArrayList();
    }


    public void build(String path, T element) throws EmptyStackException{
        if(paths.contains(path)){
throw new EmptyStackException("Cannot add element to " + path + ", already a Node at " + path);
        }

        size++;
paths.add(path);

        root = addNode(path,element,root);
    }
    public int size(){
        return size;
    }

    private Node addNode(String path, T element, Node root){
        if(root == null){
            return new Node(element);
        }
        if(path.charAt(0) == 'L'){
            root.left = addNode(path.substring(1,path.length()),element,root.left);
        }
        if(path.charAt(0) == 'R'){
            root.right = addNode(path.substring(1,path.length()),element,root.right);
        }
        return root;
    }
    public void printTree(){
        printTreeStructure();
    }
    private  void printTreeStructure() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelNodes = queue.size();
            for (int i = 0; i < levelNodes; i++) {
                Node node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            System.out.println();
        }

}







private class Node<T>{
        Node left,right;
        T data;
        Node(T element){
            data = element;
        }
}
}
