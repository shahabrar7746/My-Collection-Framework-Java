package DataStructures.Trees;

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Constructor
    BinaryTree() {
        root = null;
    }

    // Method to build the binary tree


    // Recursive method to build the binary tree from an array
    public Node buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    public ArrayList<Integer> reverseLevelOrder(Node node)
    {
        // code
        ArrayList<ArrayList<Node>> mainList =  helper(node);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = mainList.size()-1;i>=0;i--){
            ArrayList<Node> childList = mainList.get(i);
            for(int j = 0;j< childList.size();j++){
                Node listNode = childList.get(j);
                list.add(listNode.data);
            }

        }
        return list;


    }

    ArrayList<ArrayList<Node>> helper(Node node){
        //Level Order Traversal.
        Queue<Node> q = new ArrayDeque();
        q.offer(node);



        ArrayList<ArrayList<Node>> parentList = new ArrayList<>();
        while(!q.isEmpty()){
            int len = q.size();
            ArrayList<Node> list = new ArrayList<>();
            for(int i =0;i<len;i++){
                Node polledNode = q.poll();
                System.out.print(polledNode.data + " ");
                list.add(polledNode);
                if(polledNode.left != null){
                    q.offer(polledNode.left);
                }
                if(polledNode.right != null){
                    q.offer(polledNode.right);

                }

            }
            System.out.println("");
            parentList.add(list);
        }
        return parentList;
    }
    ArrayList<Integer> Kdistance(Node root, int k)
    {
        // Your code here
        ArrayList<ArrayList<Node>> mainList = helper(root);
        if(k >= mainList.size()){
            return new ArrayList<Integer>();
        }
        ArrayList<Node> childList = mainList.get(k);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i<childList.size();i++){
            list.add(childList.get(i).data);
        }
        return list;
    }
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int s) {
        // Your code here

        return   search(root,s);
    }
    boolean search(Node root,int s){
        if (root == null) return false;

        // If the current node is a leaf and its value equals the remaining sum,
        // then we've found a path from the root to a leaf with the given sum.
        if (root.left == null && root.right == null && root.data == s) return true;

        // Recursively check the left and right subtrees by subtracting the current
        // node's value from the remaining sum.
        return search(root.left, s - root.data) || search(root.right, s - root.data);
    }


    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Node>> parentList = helper(node);
        for(int i =0;i<parentList.size();i++){
            ArrayList<Node> childList = parentList.get(i);
            for(int j =0;j< childList.size();j++){
                Node listedNode = childList.get(j);
                if(listedNode.left == null && listedNode.right != null){
                    list.add(listedNode.right.data);
                }
                if(listedNode.right == null && listedNode.left != null){
                    list.add(listedNode.left.data);
                }
            }
        }
        return list;
    }
    public ArrayList<Node> nodesAtOddLevels(Node root)
    {
        //code here

        int i = 0;
        ArrayList<ArrayList<Node>> parentList = helper(root);
        ArrayList<Node> list = new ArrayList<>();
        while(i < parentList.size()){

            ArrayList<Node> childList = parentList.get(i);
            for(int j =0;j<childList.size();j++){
                list.add(childList.get(j));

            }
            i += 2;

        }
        return list;

    }
    //traversal in spiral form.
    ArrayList<Integer> findSpiral(Node root)
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Node>> parentList = helper(root);
        for(int i =1;i<=parentList.size();i++){
            ArrayList<Node> childList = parentList.get(i-1);
            if( i%2 == 1){
                    for(int j = childList.size()-1;j>=0;j--){
                        Node node = childList.get(j);
                        list.add(node.data);
                    }
            }else{
                for(int j = 0;j<childList.size();j++){
                    Node node = childList.get(j);
                    list.add(node.data);
                }
            }
        }
        return  list;

    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
      Node root =   tree.buildTree("1 3 2");
        //System.out.println(tree.reverseLevelOrder(root));


        System.out.println(tree.findSpiral(root));

    }
}
