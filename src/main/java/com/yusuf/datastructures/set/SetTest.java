package com.yusuf.datastructures.set;

import java.util.*;

public class SetTest {
    private static int size = 50_000_000;
    private static int deleteElement = 60_000_000;
    private static int searchElement = 20_000_000;

    public static void main(String[] args) {
        /*It may not be accurate to compare them as HashSet , LinkedHashSet and TreeSet serve different uses.*/

//        hashSetInsertion(); // Average for 10 million integers : 310.0 , Average for 100 thousand integers : 7.0
//        linkedHashSetInsertion(); // Average for 10 million integers : 390.0 , Average for 100 thousand integers : 11.0
//        treeSetInsertion(); // Average for 10 million integers : 1100.0 , Average for 100 thousand integers : 16.0

//        hashSetDelete(deleteElement); //size = 10_000_000 deleteElement = 5_000_000 Average Time to delete for Hashset is 0.0
//        hashSetDelete(deleteElement); //size = 50_000_000 deleteElement = 25_000_000 Average Time to delete for Hashset is 0.0
//        linkedHashSetDelete(deleteElement); //size = 10_000_000 deleteElement = 5_000_000 Average Time to delete for LinkedHashSet is 0.0
//        linkedHashSetDelete(deleteElement); //size = 50_000_000 deleteElement = 25_000_000 Average Time to delete for LinkedHashSet is 0.0
//        treeSetDelete(deleteElement); //size = 10_000_000 deleteElement = 5_000_000 Average Time to delete for TreeSet is 0.0
//        treeSetDelete(deleteElement); //size = 50_000_000 deleteElement = 25_000_000 Average Time to delete for TreeSet is 0.0


//        searchHashSet(searchElement); //size = 50_000_000, searchElement = 20_000_000 Average Time to search for HashSet is 0.0
//        searchHashSet(searchElement); //size = 50_000_000, searchElement = 49_000_000 Average Time to search for HashSet is 0.0
//        searchLinkedHashSet(searchElement); //size = 50_000_000, searchElement = 20_000_000 Average Time to search for LinkedHashSet is 0.0
//        searchLinkedHashSet(searchElement); //size = 50_000_000, searchElement = 49_000_000 Average Time to search for LinkedHashSet is 0.0
//        searchTreeSet(searchElement); //size = 50_000_000, searchElement = 20_000_000 Average Time to search for TreeSet is 0.0
//        searchTreeSet(searchElement); //size = 50_000_000, searchElement = 49_000_000 Average Time to search for TreeSet is 0.0


    }

    public static boolean searchHashSet(int element) {
        /*Java HashSet's "contains" method is used to determine whether a specified item is in the HashSet or not.
        This method searches for items quickly by using the "hashCode" method, which is a unique property of items.

        First, the hash value of the searched item is obtained by calling the item's hashCode() method. The hash value
        is used to determine the location of the item in the HashSet.

        Then, if the obtained hash value matches the hash value of an item in the HashSet, the equals() method is used
        to determine whether the items are equal. If the items are equal, the item is in the HashSet and "true" is
        returned. Otherwise, the searched item is not in the HashSet and "false" is returned.

        If no item is found with a matching hash value, it is assumed that the searched item is not in the HashSet and "false" is returned.

        This process can have a time complexity of O(1) due to the correct implementation of the items' hash values and
        the equals() method. However, if the hash values of the items are not well-distributed or there are errors in
        the equals() method, the search operation can have a time complexity of O(n).*/
        Set<Integer> integers = populateSet(new HashSet<>(), size);
        double start = System.currentTimeMillis();
        boolean result = integers.contains(element);
        double end = System.currentTimeMillis();
        System.out.println("Process: " + result + " Time to search for HashSet is " + (end - start));
        return result;
    }

    public static boolean searchLinkedHashSet(int element) {
        /*The "contains" method of Java LinkedHashSet first obtains the hash code of the searched element by calling its
         hashCode() method. Then, it looks for an entry in the hash table of the LinkedHashSet that corresponds to the
         obtained hash value. If such an entry exists, the actual position of the element in the LinkedHashSet is verified.

        Since LinkedHashSet maintains the order of the elements in which they are added, the actual positions of the
        elements are also stored in a linked list inside the LinkedHashSet. Even if there is a match in the hash table,
        the actual position of the element is verified by searching for it in the linked list. This ensures that the
        order of the elements is preserved and the "contains" method of LinkedHashSet correctly reflects the real
        ordering of the elements.

        If there is no entry that corresponds to the hash value of the searched element, it is assumed that the element
        is not in the LinkedHashSet and the method returns false. In this case, the search operation has O(1) time complexity.

        However, in some cases, the search operation can have an O(n) time complexity. This depends on the size and load
        factor of the linked list. If the load factor of the linked list is too high, i.e., the number of elements  is
        much larger than the size of the linked list, the time complexity of the search operation can be O(n). In
        this case, the size of the linked list needs to be increased or the hash values of the elements need to be
        better distributed by the hash function.*/
        Set<Integer> integers = populateSet(new LinkedHashSet<>(), size);
        double start = System.currentTimeMillis();
        boolean result = integers.contains(element);
        double end = System.currentTimeMillis();
        System.out.println("Process: " + result + " Time to search for LinkedHashSet is " + (end - start));
        return result;
    }

    public static boolean searchTreeSet(int element) {
        /*In Java, TreeSet is designed as a tree data structure that sorts its elements in their natural ordering.
        Therefore, searching for an element in a TreeSet is performed according to the natural order of the elements.
        The search process follows these steps:

        1-First, the position of the element to be searched is determined based on its natural order. This position is
         found by traversing the elements of the tree in the natural order, starting from the root of the tree.

        2-Next, a comparison is made between the searched element and the elements in the tree. This comparison is made
         using the "compareTo" method of the elements.

        3-Based on the comparison result, a branch is selected on which the search process continues, depending on the
         position of the searched element.

        4-If the searched element is found in the tree, the search process is successful and the relevant element is returned.
        Otherwise, the search process is unsuccessful and null is returned.

        5-The search process in a TreeSet has a time complexity of O(log n), depending on the height of the tree. Therefore,
         search operations in a TreeSet are quite fast.

        In summary, searching for an element in a TreeSet is performed according to the natural ordering of the elements.
        The search process involves comparing the elements based on their sorting criteria and has a time complexity of
        O(log n), depending on the height of the tree.*/
        Set<Integer> integers = populateSet(new TreeSet<>(), size);
        double start = System.currentTimeMillis();
        boolean result = integers.contains(element);
        double end = System.currentTimeMillis();
        System.out.println("Process: " + result + " Time to search for TreeSet is " + (end - start));
        return result;
    }

    public static boolean hashSetDelete(int element) {
        /*To remove an element in a HashSet, the position of the element is first determined using the hash value
        calculated with the element's hashCode() method, and then it is directly removed. This process is done in a
        relatively constant time.*/
        Set<Integer> integers = populateSet(new HashSet<>(), size);
        double start = System.currentTimeMillis();
        boolean result = integers.remove(element);
        double end = System.currentTimeMillis();
        System.out.println("Process: " + result + " Time to delete for HashSet is " + (end - start));
        return result;
    }

    public static boolean linkedHashSetDelete(int element) {
        /*LinkedHashSet is a subset of HashSet that stores elements both in a hash table and in a doubly linked list.
        LinkedHashSet maintains the order in which the elements are added and tracks the position of an element, unlike
        HashSet. When an element is deleted, it is first removed from the doubly linked list and then removed from the
        hash table. This process is done in a relatively constant time.*/
        Set<Integer> integers = populateSet(new LinkedHashSet<>(), size);
        double start = System.currentTimeMillis();
        boolean result = integers.remove(element);
        double end = System.currentTimeMillis();
        System.out.println("Process: " + result + " Time to delete for LinkedHashSet is " + (end - start));
        return result;
    }

    public static boolean treeSetDelete(int element) {
        /*TreeSet stores the elements in a tree structure, which keeps the elements in a sorted order, and uses a placement
         that puts every element smaller than itself to the left, and every element larger than itself to the right.
         Insertion, searching, and deletion of elements may require joining, splitting, and rotating operations to
         maintain the balance of the tree structure. As a result, deletion operations take logarithmic time on average.
         */
        Set<Integer> integers = populateSet(new TreeSet<>(), size);
        double start = System.currentTimeMillis();
        boolean result = integers.remove(element);
        double end = System.currentTimeMillis();
        System.out.println("Process: " + result + " Time to delete for TreeSet is " + (end - start));
        return result;
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
