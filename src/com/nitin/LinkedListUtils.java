package com.nitin;

/**
 * Created by harsh on 3/15/16.
 */
public class LinkedListUtils {

    public static boolean isProper(Node top) {
        if (top.prev != null)
            return false;
        while (top.next != null) {
            Node temp = top;
            top = top.next;
            if (top.prev != temp) {
                return false;
            }
            if (temp.next != top) {
                return false;
            }
        }
        return true;
    }
    public static int countElements(Node top) {
        int size = 0;
        Node t = top;
        while (t != null) {
            t = t.next;
            size++;
        }
        return size;
    }

    public static boolean hasCycle(Node top) {
        if (top == null)
            return false;
        Node firstNode = top;
        while (firstNode != null) {
            Node secondNode = firstNode.next;
            while (secondNode != null) {
                if (secondNode == firstNode) {
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
        link.bottom = n;
        myAssert(isProper(link.top));
    }
}