package com.yusuf.datastructures.set;

import java.util.*;

public class SetTest {
    private final static int size = 50_000_000;
    private final static int deleteElement = 60_000_000;

    public static void main(String[] args) {
        /*It may not be accurate to compare them as HashSet , LinkedHashSet and TreeSet serve different uses.*/

//        hashSetInsertion(); // Average for 10 million integers : 310.0 , Average for 100 thousand integers : 7.0
//        linkedHashSetInsertion(); // Average for 10 million integers : 390.0 , Average for 100 thousand integers : 11.0
//        treeSetInsertion(); // Average for 10 million integers : 1100.0 , Average for 100 thousand integers : 16.0

//        deleteHashSet(deleteElement); //size = 10_000_000 deleteElement = 5_000_000 Average Time to delete for Hashset is 0.0
//        deleteHashSet(deleteElement); //size = 50_000_000 deleteElement = 25_000_000 Average Time to delete for Hashset is 0.0
//        deleteLinkedHashSet(deleteElement); //size = 10_000_000 deleteElement = 5_000_000 Average Time to delete for LinkedHashSet is 0.0
//        deleteLinkedHashSet(deleteElement); //size = 50_000_000 deleteElement = 25_000_000 Average Time to delete for LinkedHashSet is 0.0
//        deleteTreeSet(deleteElement); //size = 10_000_000 deleteElement = 5_000_000 Average Time to delete for TreeSet is 0.0
//        deleteTreeSet(deleteElement); //size = 50_000_000 deleteElement = 25_000_000 Average Time to delete for TreeSet is 0.0


    }

    public static boolean deleteHashSet(int element) {
        /*To remove an element in a HashSet, the position of the element is first determined using the hash value
        calculated with the element's hashCode() method, and then it is directly removed. This process is done in a
        relatively constant time.*/
        Set<Integer> integers = populateSet(new HashSet<>(), size);
        double start = System.currentTimeMillis();
        boolean remove = integers.remove(element);
        double end = System.currentTimeMillis();
        System.out.println("Process: " + remove + " Time to delete for HashSet is " + (end - start));
        return remove;
    }

    public static boolean deleteLinkedHashSet(int element) {
        /*LinkedHashSet is a subset of HashSet that stores elements both in a hash table and in a doubly linked list.
        LinkedHashSet maintains the order in which the elements are added and tracks the position of an element, unlike
        HashSet. When an element is deleted, it is first removed from the doubly linked list and then removed from the
        hash table. This process is done in a relatively constant time.*/
        Set<Integer> integers = populateSet(new LinkedHashSet<>(), size);
        double start = System.currentTimeMillis();
        boolean remove = integers.remove(element);
        double end = System.currentTimeMillis();
        System.out.println("Process: " + remove + " Time to delete for LinkedHashSet is " + (end - start));
        return remove;
    }

    public static boolean deleteTreeSet(int element) {
        /*TreeSet stores the elements in a tree structure, which keeps the elements in a sorted order, and uses a placement
         that puts every element smaller than itself to the left, and every element larger than itself to the right.
         Insertion, searching, and deletion of elements may require joining, splitting, and rotating operations to
         maintain the balance of the tree structure. As a result, deletion operations take logarithmic time on average.
         */
        Set<Integer> integers = populateSet(new TreeSet<>(), size);
        double start = System.currentTimeMillis();
        boolean remove = integers.remove(element);
        double end = System.currentTimeMillis();
        System.out.println("Process: " + remove + " Time to delete for TreeSet is " + (end - start));
        return remove;
    }


    public static Set<Integer> populateSet(Set<Integer> set, int size) {
        Set<Integer> integers = set;
        for (int i = 0; i < size; i++) {
            integers.add(i);
        }
        return integers;
    }


    public static void hashSetInsertion() {
        Set<Integer> integers = new HashSet<>();
        double start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            integers.add(i);
        }
        double end = System.currentTimeMillis();
        System.out.println("Time for HashSet is " + (end - start));
    }


    public static void linkedHashSetInsertion() {

        /*
        LinkedHashSet is a subclass of HashSet and stores elements sequentially. It also ensures that each element is unique.

        In addition to the properties of the HashSet class, the LinkedHashSet class stores elements in the order they were
        added.That is, the sequential storage of elements is guaranteed. Therefore, LinkedHashSet may be preferred over HashSet
        when elements need to be stored in a specific order.

        The key difference between the HashSet and LinkedHashSet classes is the way the elements are stored. HashSet
        stores elements in a hash table and sequential storage of elements is not guaranteed. LinkedHashSet, on the other
        hand, stores the elements in a hash table, but also in a linked list, so that the elements are guaranteed to be
        stored in a sequential manner.

        The LinkedHashSet class is part of the Java Collection Framework and implements the Set interface. Therefore, the
         LinkedHashSet class supports all methods defined in the Set interface.*/

        Set<Integer> integers = new LinkedHashSet<>();
        double start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            integers.add(i);
        }
        double end = System.currentTimeMillis();
        System.out.println("Time for LinkedHashSet is " + (end - start));
    }


    public static void treeSetInsertion() {

        /*
        In Java, the TreeSet class is a data structure that stores a set of elements in a sorted order. TreeSet uses a
        key to access its elements and keeps the elements sorted in the data structure. TreeSet also ensures uniqueness
        of the elements, allowing each element to be added only once.

        TreeSet implements the Set interface and implements the NavigableSet interface to ensure the sorting of elements.
        Therefore, TreeSet has many useful methods to sort, navigate and search for elements. TreeSet sorts its elements
        according to their natural ordering. For example, if a String is added to a TreeSet, the elements are sorted in
        alphabetical order.

        For an element to be added to TreeSet, it must be a comparable object. If the elements are not comparable, a
        Comparator object must be specified. TreeSet also provides methods for removing, finding, creating subsets and
        returning elements in ranges.

        TreeSet stores its elements using a tree structure. This means that operations like adding, removing and searching
        for elements have a time complexity of O(log n). However, TreeSet uses a little more memory to keep its elements
        sorted and may be slightly slower for adding and removing elements. */

        Set<Integer> integers = new TreeSet<>();
        double start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            integers.add(i);
        }
        double end = System.currentTimeMillis();
        System.out.println("Time for TreeSet is " + (end - start));
    }


    public static void hashSetVsArrayList() {

        /*
        HashSet and ArrayList are different data structures and serve different needs. Therefore, directly comparing
        them is not very meaningful.

        ArrayList can be thought of as a dynamic array. It can store elements in a sorted manner and elements can be accessed
        through index numbers. It is a sequential data structure and is generally preferred when elements need to be stored
        in a specific order or when index-based operations need to be performed on the elements.

        On the other hand, HashSet can be thought of as a set. It keeps elements unique and does not guarantee that elements
        are stored in a sorted manner. There is no ordering among the elements, and elements cannot be accessed through
        index numbers. It is generally used when unique elements need to be stored.

        Therefore, ArrayList and HashSet are data structures that serve different purposes. Which data structure to use
        is determined by the requirements of the function and the performance goals.*/

        // HashSet add
        HashSet<Integer> hashSet = new HashSet<>();
        double start1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            hashSet.add(i);
        }
        double end1 = System.currentTimeMillis();
        System.out.println("Time for HashSet is " + (end1 - start1));

        // ArrayList add
        ArrayList<Integer> arrayList = new ArrayList<>();
        double start2 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        double end2 = System.currentTimeMillis();
        System.out.println("Time for ArrayList is " + (end1 - start2));
    }
}
