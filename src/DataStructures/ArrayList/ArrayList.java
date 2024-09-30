package DataStructures.ArrayList;

import Exceptions.ArrayList.ArrayListOutOffBound;
import Interfaces.List;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private class Node<T>{
        T data;
        Node(T data){
            this.data = data;
        }
    }
private Node arr[];
private int size;
private int index;


ArrayList(int size){
    this.size = size;
    this.arr =  new Node[size];
    index =0;
}
ArrayList(){
    this.size = 10;
    this.arr =  new Node[size];
    index =0;
}
private boolean isFull(){
    return index>= arr.length;
}

public void add(T element){
    if(isFull()){
        arr = Arrays.copyOf(arr,arr.length*2);
    }

    arr[index] = new Node(element);
    index++;
    size++;


}
public T get(int index) throws ArrayListOutOffBound{
    if( index <= index){
        throw new ArrayListOutOffBound("Array out off bound index for " + index);
    }
    return (T) arr[index];
}

public void remove(int index) throws ArrayListOutOffBound{
    if( index >= size){
        throw new ArrayListOutOffBound("Array out off bound index for length " + size);
    }


    rearrange(index);
    index--;
    size--;

}
private void rearrange(int index){
    for(int i = index;i+1< arr.length;i++){
        arr[i] = arr[i+1];
    }
}

public String toString(){
    String str = "{ ";
    for(int i =0;i<size;i++){
        str = str + String.valueOf(arr[i] + ",");
    }
    StringBuilder build = new StringBuilder(str);
    build.replace(build.length()-1,build.length(),"}");



    return build.toString();
}


public int size(){
    return  size;
}

    public static void main(String[] args) throws ArrayListOutOffBound {
        ArrayList list = new ArrayList(2);
        list.add(90);
        list.add("abrar");
        list.add("shaha");




        list.remove(1);
        System.out.println(list);
    }
}
