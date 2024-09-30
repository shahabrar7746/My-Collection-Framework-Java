package DataStructures.Stack;

import Exceptions.Stack.EmptyStackException;

public class Stack<T> {
    private class Node<T>{
        private T data;
        private Node down;
        public Node(T data){
            this.data = data;
        }
    }

    private Node top;
    private int size;

    public int size(){
        return size;
    }

    public Stack(){
        size = 0;
    }
    public void push(T element){
        size++;
    addNode(element);
    }
    private void addNode(T element){
        Node node = new Node(element);
        node.down = top;
        top = node;

    }
    public T pop() throws NullPointerException{
        if(top == null){
            throw new NullPointerException("Removing from empty stack");
        }size--;
        Node node = top;
        top = top.down;
        return (T) node.data;
    }

    public T peek() throws EmptyStackException {
        if(top == null){
            throw new EmptyStackException("Cannot peek from empty stack");
        }
        return (T) top.data;
    }
    public String toString(){
        String str = "";
        Node node = top;
        while(node != null){
            str = str + node.data + " -> ";
            node = node.down;
        }
        str = str + "BASE";
        return str;
    }
}
