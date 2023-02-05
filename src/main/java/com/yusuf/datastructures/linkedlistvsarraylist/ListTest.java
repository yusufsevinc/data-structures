package com.yusuf.datastructures.linkedlistvsarraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    private static int size = 10000000;
    private static int searchIndex = 10000000;

    public static void main(String[] args) {

        //In this test, prepend.
//        arrayListInsertion();  // Average for 1 million integers : 257352.0
//        linkedListInsertion(); // Average for 1 million integers : 155.0

        //In this test, add in the middle.
//        arrayListInsertion();  // Average for 1 million integers : 24443.0
//        linkedListInsertion();// Average for 1 million integers : 736483.0
//        System.out.println(Arrays.toString(list.toArray()));;


        //In this test, Insert at end.
//        arrayInsertion(); // Average for 1 million integers : 7.0
//        arrayListInsertion();  // Average for 1 million integers : 12.0
//        linkedListInsertion(); // Average for 1 million integers : 155.0

//        arraySearch(size, searchIndex); //size = 10_000_000, searchIndex = 10_000_000 Average Time to search for simple array is 12.0
//        arrayListSearch(size, searchIndex); //size = 10_000_000, searchIndex = 10_000_000 Average Time to search for ArrayList is 21.0
//        linkedListSearch(size, searchIndex); //size = 10_000_000, searchIndex = 10_000_000 Average Time to search for LinkedList is 63.0

//        arraySearch(size, searchIndex); //size = 10_000_000, searchIndex = 1_000_000 Average Time to search for simple array is 5.0
//        arrayListSearch(size, searchIndex); //size = 10_000_000, searchIndex = 1_000_000 Average Time to search for ArrayList is 7.0
//        linkedListSearch(size, searchIndex); //size = 10_000_000, searchIndex = 1_000_000 Average Time to search for LinkedList is 16.0

//        arrayListDelete(size, 0); //size = 10_000_000, searchIndex = 0 Average Time to delete for ArrayList is 9.0
//        linkedListDelete(size, 0); //size = 10_000_000, searchIndex = 0 Average Time to delete for LinkedList is 0.0
//        arrayListDelete(size, size - 1); //size = 10_000_000 Average Time to delete for ArrayList is 0.0
//        linkedListDelete(size,size - 1 ); //size = 10_000_000 Average Time to delete for LinkedList is 0.0
//
        /* When removing an element from the middle of an ArrayList in Java, the index of the element to be removed is
          found, and all elements to the right of the removed element are shifted one position to the left. Then, the
          size of the ArrayList is decremented. The time complexity of this process may vary based on the size of the
          ArrayList and the index of the element to be removed, but generally has a time complexity of O(n), where
          n is the size of the ArrayList.*/
//        arrayListDelete(size, size / 2); //size = 10_000_000 Average Time to delete for ArrayList is 5.0

        /* To remove an element from the middle of a linked list containing integer values, the following steps can be taken:
          1- Find the index of the element to be removed from the middle of the linked list.
          2- Call the "remove" method of the LinkedList class using this index value to remove the element.
          3- This method will find the node in the linked list based on the given index value and call the "unlink" method
           to perform the necessary operations to remove the node.

          The necessary operations to remove a node from a linked list are:
          1- Get the references (next and prev) of the node to be removed.
          2- If the previous node (prev) exists, change the "next" reference of the previous node to the next node of the node to be removed.
          3- If the next node (next) exists, change the "prev" reference of the next node to the previous node of the node to be removed.
          4- Set the references of the node to be removed to null and decrease the size of the linked list.

          The time complexity of removing an element from the middle of a linked list is O(n), where n is the number of
          elements in the linked list.

          This is because in the worst-case scenario, you need to traverse the entire linked list to find the node with
          the given index, which takes O(n) time. Once you have found the node, the actual removal operation is a
          constant-time operation, O(1), as it simply involves updating the references of the neighboring nodes and
          adjusting the size of the linked list.

          Therefore, the overall time complexity of removing an element from the middle of a linked list is O(n).*/
//        linkedListDelete(size, size/2); //size = 10_000_000 Average Time to delete for LinkedList is 34.0

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

    public static void arraySearch(int size, int k) {
        Integer[] sArray = populateArray(size);

        double start = System.currentTimeMillis();
        for (Integer i : sArray)
            if (i == k)
                break;
        double end = System.currentTimeMillis();
        System.out.println("Time to search for simple array is " + (end - start));
    }

    public static void arrayListSearch(int size, int k) {
        ArrayList<Integer> aList = populateArrayList(size);

        double start = System.currentTimeMillis();
        for (Integer i : aList)
            if (i == k)
                break;
        double end = System.currentTimeMillis();
        System.out.println("Time to search for ArrayList is " + (end - start));
    }

    public static void linkedListSearch(int size, int k) {
        LinkedList<Integer> lList = populateLinkedList(size);

        double start = System.currentTimeMillis();
        lList.get(0);
        for (Integer i : lList)
            if (i == k)
                break;
        double end = System.currentTimeMillis();
        System.out.println("Time to search for LinkedList is " + (end - start));
    }

    public static void arrayListDelete(int size, int k) {
        ArrayList<Integer> aList = populateArrayList(size);

        double start = System.currentTimeMillis();
        aList.remove(k);
        double end = System.currentTimeMillis();
        System.out.println("Time to delete for ArrayList is " + (end - start));
    }

    public static void linkedListDelete(int size, int k) {
        LinkedList<Integer> lList = populateLinkedList(size);

        double start = System.currentTimeMillis();
        lList.remove(k);
        double end = System.currentTimeMillis();
        System.out.println("Time to delete for LinkedList is " + (end - start));
    }

    private static Integer[] populateArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static ArrayList populateArrayList(int size) {
        ArrayList list = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    private static LinkedList populateLinkedList(int size) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }
}
