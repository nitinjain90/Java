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

    public boolean isEmpty(){
        return (top==null);
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
          previousBottom.next = bottom;
          size++;
      }
    }

    public String pop(){
       if(size <= 0){
           throw new IllegalArgumentException("empty queue");
       }
        String t = top.data;
        top = top.next;
        size--;
        return t;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String args[]){
        QueuePointer q = new QueuePointer();
        q.push("hello");
        q.push("world");
        q.push("nitin");
        q.push("kill me");

        myAssert(q.pop().equals("hello"));
        myAssert(q.pop().equals("world"));
        myAssert(q.pop().equals("nitin"));
        myAssert(q.pop().equals("kill me"));

        q.pop();

    }

}
