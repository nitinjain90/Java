package com.nitin;

/**
 * Created by harsh on 3/15/16.
 */
public class LinkedListUtils {

    public static boolean isProper(Node top) {
        if (top.prev != null)
            return false;
        if (hasCycle(top)) {
            return false;
        }
        while (top != null) {
            Node first = top;
            Node second = top.next;
            if (second != null) {
                if (second.prev != first) {
                    return false;
                }
            }
            top = top.next;
        }


        return true;
    }

//    public static boolean checkBottom(Node top){
//        Node bottom = null;
//        Node beforeBottom = null;
//        while(top != null){
//            top = top.next;
//            if(top.next.next == null){
//                bottom = top.next;
//                beforeBottom = top;
//            }
//        }
//        if(!(bottom.prev).equals(beforeBottom))
//            return false;
//         else
//        return true;
//    }

    public static int countElements(Node top) {
        if (isProper(top)) {
            int size = 0;
            Node t = top;
            while (t != null) {
                t = t.next;
                size++;
            }
            return size;
        } else
            return -1;
    }

    public static boolean hasCycle(Node top) {
        if (top == null)
            return false;
        Node firstNode = top;
        while (firstNode != null) {
            Node secondNode = firstNode.next;
            while (secondNode != null) {
                if (secondNode.equals(firstNode)) {
                    return true;
                }
                secondNode = secondNode.next;
            }
            firstNode = firstNode.next;
        }
        return false;
    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String args[]) {
        LinkedList link = new LinkedList();
        Node n = new Node("hello", null, null);
        link.addFirst("1");
        link.addFirst(null);
        link.addLast("3");
        link.addFirst("4");
        link.addFirst("5");


        myAssert(countElements(link.top) == 5);


        myAssert(isProper(link.top));

        link.top.prev = n;
        myAssert(!isProper(link.top));

        link.top.prev = null;

        myAssert(isProper(link.top));

//         link.top.next = n;
//         myAssert(!isProper(link.top));
//        link.top.next.next = n;
//
//        myAssert(!isProper(link.top));
//
//        link.top.next.next.prev = n;
//
//        myAssert(!isProper(link.top));



        myAssert(isProper(link.top));

    }
}