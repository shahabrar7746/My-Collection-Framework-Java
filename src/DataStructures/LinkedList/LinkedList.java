package DataStructures.LinkedList;
import Interfaces.List;


public class LinkedList<T> implements Cloneable, List<T>{


    private int size;
    private  Node head;
    private Node tail;


    public LinkedList(LinkedList list) throws Exception {
      for(int i =0;i<list.size();i++){
          this.add((T) list.get(i));
      }
    }

public LinkedList getClone() throws CloneNotSupportedException {
        return (LinkedList) this.clone();
}

    public LinkedList(T arr[]){
        for(T element : arr){
            add(element);
        }
    }


    public LinkedList(){
size = 0;
    }



    public  void add(T element){
        if(head == null){
            size++;
            Node node = new Node(element);
            head = node;
            tail = node;
            return;

        }
size++;


        tail.next = new Node(element);
        tail = tail.next;
    }

    public T get(int index) throws Exception{
        if(size <= index){
            throw new Exception("LinkedList Out off bound index for " + index + " in length " + size);
        }

        Node node = head;
        for(int i =0;i<index && node != null;i++){
            node = node.next;
        }
        T data = (T) node.data;
        return data;
    }

    public T remove() throws  Exception{
        if(size == 0){
            throw new Exception("Removing from Empty List is prohibited");
        }
        T element = (T) head.data;
        if(head == tail){
            head  = null;
            tail = null;
           size--;
            return element;
        }
        size--;

        head = head.next;
        return element;

    }


    public void addAt(int index,T element) throws Exception{
        if(size == 0){
            add(element);
            return;
        }
        if(index < 0){
            throw new Exception("Index cannot be lesser than zero");
        }
        if(index == 0){
            Node node = new  Node(element);
            node.next = head;
            head = node;
            size++;
            return;
        }
        if(index >= size){
           add(element);
            return;
        }

        Node node = head;
        for(int i =0;i<index-1;i++){
            node = node.next;
        }
        Node temp = node.next;
        node.next = new Node(element);
        node = node.next;
        node.next = temp;
        size++;
    }
public int size(){
        return size;
}
    public String toString(){
        String str = "";
        Node node = head;
        while(node != null){
            str = str + node.data + " -> ";
            node = node.next;
            //System.out.println(node.data);
        }
        str = str + "NULL";
        return str;
    }








    private class  Node<T>{
        private T data;
         private Node next;
       Node(T element){
           data = element;
       }

    }
}

