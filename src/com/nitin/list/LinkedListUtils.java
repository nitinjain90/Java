package com.nitin.list;

/**
 * Created by harsh on 3/15/16.
 */
public class LinkedListUtils {

    public static boolean isProper(Node top) {
        if (top == null) {
            return false;
        }
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
        Node secondNode = top;

        while (true) {
            firstNode = firstNode.next;

            if (secondNode.next != null) {
                secondNode = secondNode.next.next;
            } else {
                return false;
            }

            if (firstNode == null || secondNode == null) {
                return false;
            }
            if(firstNode == secondNode){
                return true;
            }
        }

    }

    private static void myAssert(boolean condition) {
        if (!condition) throw new IllegalStateException("Something is wrong");
    }

    public static void main(String args[]) {
        LinkedList link = new LinkedList();
        Node n = new Node("hello", null, null);
        link.addFirst("1");
        link.addFirst("2");
        link.addFirst("3");

        myAssert(countElements(link.top) == 3);


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

        link.top.next.next = n;
        myAssert(!isProper(link.top));

        LinkedList newLink = new LinkedList();
        newLink.addFirst("nitin");
        newLink.addLast("harsh");
        newLink.addFirst("hello");
        newLink.addLast("world");
        newLink.addFirst("1");
        newLink.addLast("2");

        myAssert(countElements(newLink.top) == 6);

        newLink.removeFirst();
        myAssert(countElements(newLink.top) == 5);
        newLink.removeLast();

        myAssert(countElements(newLink.top) == 4);


        isProper(newLink.top);

        Node n1;

        n1 = null;
        myAssert(!isProper(n1));

        newLink.top = newLink.bottom;

        myAssert(!isProper(newLink.top));
        myAssert(countElements(newLink.top) == -1);

        LinkedList l = new LinkedList();
        l.addFirst("india");
        l.addLast("pakistan");
        l.addLast("sri lannka");
        l.addLast("new zealand");
        l.addLast("south africa");
        l.addLast("australia");


        myAssert(!hasCycle(l.top));

        l.addFirst(null);
        myAssert(!hasCycle(l.top));

        l.bottom.next = l.top;

        myAssert(hasCycle(l.top));

        l.bottom.next = null;

        myAssert(!hasCycle(l.top));

        l.bottom.next = l.top.next;

        myAssert(hasCycle(l.top));

        l.bottom.next = null;

        myAssert(!hasCycle(l.top));

        l.top.next.next = l.top;

        myAssert(hasCycle(l.top));

        LinkedList test = new LinkedList();

        test.addFirst("English");
        test.addFirst("Hindi");
        test.addLast("Spanish");
        test.addLast(null);
        test.addLast("French");

        myAssert(countElements(test.top) == 5);

        test.removeFirst();

        myAssert(countElements(test.top) == 4);

        test.top.next.next.next.next = test.top;

        myAssert(hasCycle(test.top));

        myAssert(!isProper(test.top));

        myAssert(countElements(test.top) == -1);
    }
}