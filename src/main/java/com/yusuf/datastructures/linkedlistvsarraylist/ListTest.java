package com.yusuf.datastructures.linkedlistvsarraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    private static int size = 1000000;

    public static void main(String[] args) {

        //In this test, prepend.
//        arrayListInsertion();  // Average for 1 million integers : 257352.0
        linkedListInsertion(); // Average for 1 million integers : 155.0

        //In this test, add in the middle.
//        arrayListInsertion();  // Average for 1 million integers : 24443.0
//        linkedListInsertion();// Average for 1 million integers : 736483.0
//        System.out.println(Arrays.toString(list.toArray()));;


        //In this test, Insert at end.
//        arrayInsertion(); // Average for 1 million integers : 7.0
//        arrayListInsertion();  // Average for 1 million integers : 12.0
//        linkedListInsertion(); // Average for 1 million integers : 155.0
    }

    public static void arrayInsertion() {
        Integer[] integers = new Integer[size];
        double start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            integers[i] = i;
        }
        double end = System.currentTimeMillis();
        System.out.println("Time for array is " + (end - start));
    }

    public static ArrayList arrayListInsertion() {
        ArrayList aList = new ArrayList();
        double start = System.currentTimeMillis();

        aList.add(1000001);
        aList.add(1000002);
        for (int i = 0; i < size; i++) {
            if (aList.size() % 2 == 0) {
                aList.add(aList.size() / 2, i);
            } else {
                aList.add((aList.size() + 1) / 2, i);
            }
//          aList.add(0, i);
//			aList.add(i);
        }
        double end = System.currentTimeMillis();
        System.out.println("Time for ArrayList is " + (end - start));
        return aList;
    }

    public static List linkedListInsertion() {
        List lList = new LinkedList();
        double start = System.currentTimeMillis();
        lList.add(1000001);
        lList.add(1000002);

        for (int i = 0; i < size; i++) {
            if (lList.size() % 2 == 0) {
                lList.add(lList.size() / 2, i);
            } else {
                lList.add((lList.size() + 1) / 2, i);
            }
//            lList.add(0,1);
//            lList.add(i);
        }
        double end = System.currentTimeMillis();
        System.out.println("Time for LinkedList is " + (end - start));
        return lList;
    }
}
