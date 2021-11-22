package com.solvd.talab.generics;

public class Node<T> {
    T data; //Data in the current node
    Node next; //Reference for the next node

    Node(T data){
        this.data = data;
    }
}
