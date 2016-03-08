package com.nitin;

/**
 * Created by harash on 08/03/16.
 */
public class QueuePointer {

      Node bottom;
      Node top;
      int size;

    public class Node{
        String data;
        Node prev;
        Node next;
    }

    public QueuePointer(){
       bottom = null;
       top = null;
       size = 0;
    }

    public void push(String s){
      if(size == 0) {
          top = new Node();
          bottom = new Node();
          bottom.data = s;
          top.data = s;
          size++;
      } else {
          Node previousBottom = bottom;
          bottom = new Node();
          bottom.data = s;
          bottom.prev = previousBottom;
          bottom.next = null;
          size++;
      }
    }

    public String pop(){
        String t = top.data;
        top  = top.next;
        size--;
        return t;
    }

    public static void main(String args[]){
        QueuePointer q = new QueuePointer();
        q.push("hello");
        q.push("world");
        q.push("nitin");
        q.push("kill me");


        assert  q.pop().equals("hello");
        assert  q.pop().equals("world");
        assert  q.pop().equals("nitin");
        assert  q.pop().equals("kill me");



    }

}
