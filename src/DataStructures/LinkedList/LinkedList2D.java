package DataStructures.LinkedList;



import java.util.*;


public class LinkedList2D<T> {
    private int size;
    private int width;
    private int curIndex;
    private int index;
    private Node[] nodeArr;
    private String shortestPath;
    private ArrayList<Integer> costList;
    private HashMap<Integer,String> paths;
    private T lastFrom;
    private  T lastElement;
            private Node head;



    public LinkedList2D(int width){
        size = 0;
        index =0;
        this.width = width;
        curIndex = width;
        nodeArr = new Node[width-1];
       costList = new ArrayList<>();
        shortestPath = "";
        paths = new HashMap<>();
     lastFrom = (T) new Object();
     lastElement = (T) new Object();
    }
    private void populateArray(){
        Node node = head;
        while(node.down != null){
            node = node.down;
        }
        node = node.right;
        int index  =0;
        while(node != null){

            nodeArr[index] = node;
            index++;
            node = node.right;

        }
    }


    public void add(T element){

if(curIndex == 0){
    this.index = 0;
    populateArray();
    addAtNewLevel(element);
    curIndex = width-1;
    size++;
    return;
}
curIndex--;
size++;
     addHelper(element);
    }
    public void addAtNewLevel(T element){
        Node node = head;
        while(node.down != null){
            node = node.down;
        }

        Node newNode = new Node(element);
        node.down = newNode;
        newNode.up = node;
        newNode.right = null;

    }
    private void addHelper(T element){
        Node node = head;
        if(head == null){
            head = new Node(element);
            return;
        }
        if(node.right == null){
            Node newNode = new Node(element);
            node.right =newNode;
            newNode.left = node;
            return;
        }
        while(node.down != null){
          node =  node.down;
        }
        while(node.right != null){
            node = node.right;

        }
        Node arrNode = nodeArr[this.index];

        Node newNode = new Node(element);
        if(arrNode != null) {
            arrNode.down = newNode;
        }
        newNode.up = arrNode;
        index++;
        node.right
                = newNode;
        newNode.left = node;
    }

    public int size() {
        return size;
    }

    public void print(){

        Node node = head;
        while(node != null){
            Node levelNode = node;
            while (levelNode != null){
                System.out.print(levelNode.data + " ");
                levelNode = levelNode.right;
            }
            System.out.println();
            node = node.down;
        }
    }
    public void printBackward(){
        Node node = head;
        while(node.down != null){
            node = node.down;
        }
        while (node.right != null){
            node = node.right;
        }
        while(node != null){
            Node levelNode = node;
            while (levelNode.left != null){
                System.out.print(levelNode.data + " ");
                levelNode = levelNode.left;
            }
            System.out.println();
            node = levelNode.up;
        }

    }



    public String findShortestPathFrom(T from,T element){
        Node node = head;



        if(paths.size() > 0 && (lastElement.equals(element) && lastFrom.equals(from))  ){
            paths = new HashMap<>();
            costList = new ArrayList<>();
            node = null;
        }
        while(node != null){
            Node levelNode = node;
            while(levelNode != null && !from.equals(levelNode.data)){
                levelNode = levelNode.right;
            }

            if(levelNode != null && from.equals(levelNode.data)){
                  // findEfficientPaths(element,levelNode,"");
                paths = new HashMap<>();
                costList = new ArrayList<>();
               findEfficientPaths(element,levelNode,"",0,paths);
                break;
            }
            node = node.down;
        }

     Collections.sort(costList);

       if(costList.size() <= 0){
           return "";
       }

        return  paths.get(costList.get(0));
    }
public String findShortestPathOf(T element){
        findEfficientPaths(element,head,"");



        return shortestPath;
}
private void  findEfficientPaths(T element, Node node, String curPath){
        if(node == null || node.data.equals(element)){
            if(node == null){

                return ;
            }

            if(node.data.equals(element)){

                    //paths.add(curPath);
                return;


            }
        }






        if(node.down != null && !node.down.isVisited){
            //call below node.
            node.down.isVisited = true;
            findEfficientPaths(element,node.down,curPath + "D");
            node.down.isVisited = false;
        }
    if(node.up != null && !node.up.isVisited){
       // node.up.visitedNodes.add(node.data);
        node.up.isVisited = true;
        findEfficientPaths(element,node.up,curPath + "U");
        node.up.isVisited = false;
    } if(node.right != null && !node.right.isVisited){
        //node.right.visitedNodes.add(node.data);
        node.right.isVisited = true;
        findEfficientPaths(element,node.right,curPath + "R");
        node.right.isVisited = false;
    }
    if(node.left != null && !node.left.isVisited){
        node.left.isVisited = true;
        findEfficientPaths(element,node.left,curPath + "L");
        node.left.isVisited = false;
    }







}
    public String findMostEfficientPath(T from, T element){
      //  HashMap<Integer,String> paths = new HashMap<Integer, String>();
        Node node = head;
//        if(paths.size() > 0 && (lastElement.equals(element) && lastFrom.equals(from))  ){
//            if(costList.size() > 0){
//                Collections.sort(costList);
//                System.out.println("in efficient");
//                return paths.get(costList.get(0));
//
//            }
//            node = null;
//        }

        while(node != null){
            Node levelNode = node;
            while(levelNode != null && !levelNode.data.equals(from)){

                levelNode = levelNode.right;
            }


            if(levelNode != null && levelNode.data.equals(from)){
                paths = new HashMap<>();
                costList = new ArrayList<>();
             findEfficientPaths(element,levelNode,"",0,paths);
                break;
            }
            node = node.down;
        }
      if(costList.size() > 0){
          Collections.sort(costList);
          return paths.get(costList.get(0));

      }

     return "";
    }

    private void findEfficientPaths( T element,Node node, String path,int cost, HashMap<Integer,String> paths){
        if(node == null || node.data == element){
            if(node == null){
                return;
            }
            if(node.data == element){
                costList.add(cost);
                paths.put(cost,path);

                return;
            }
        }


        if(node.down != null && !node.down.isVisited){
            //call below node.
            node.down.isVisited = true;
            findEfficientPaths(element,node.down,path + "D",cost + (int) node.data,paths);
            node.down.isVisited = false;
        }
        if(node.up != null && !node.up.isVisited){
            // node.up.visitedNodes.add(node.data);
            node.up.isVisited = true;
            findEfficientPaths(element,node.up,path + "U",cost  + (int) node.data,paths);
            node.up.isVisited = false;
        } if(node.right != null && !node.right.isVisited){
            //node.right.visitedNodes.add(node.data);
            node.right.isVisited = true;
            findEfficientPaths(element,node.right,path + "R",cost + (int) node.data, paths);
            node.right.isVisited = false;
        }
        if(node.left != null && !node.left.isVisited){
            node.left.isVisited = true;
            findEfficientPaths(element,node.left,path + "L",cost + (int) node.data, paths);
            node.left.isVisited = false;
        }







    }


    private class Node<T>{
        private boolean isVisited;
        private T data;
        private Node right,left,up,down;
        Node(T data){
            isVisited = false;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList2D list = new LinkedList2D(12);


        String alpha = "ASDFGHJKLQWERTYUIOPZXCVBNM";
        for(int i =1;i<=100;i++) {
            Random rand= new Random();

String str = String.valueOf(rand.nextInt(alpha.length()*5));
//                list.add( str + (char) alpha.charAt(rand.nextInt(alpha.length())));
list.add(rand.nextInt(alpha.length()*5));

        }

        list.print();
      // System.out.println(list.findShortestPathOf(23));

        System.out.println();
        Scanner sc  = new Scanner(System.in);
     int from = sc.nextInt();
        int element = sc.nextInt();

//        String from = sc.nextLine();
//        String element = sc.nextLine();

        System.out.println(" shortest Path : " + list.findShortestPathFrom(from,element));

      //  from = sc.nextInt();
        // element = sc.nextInt();
        System.out.println( "Most effficient path : "+list.findMostEfficientPath(from,element));
    }
}
