package com.nitin.list;

public class Node {
    String data;
    Node prev;
    Node next;

    public Node(String data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}