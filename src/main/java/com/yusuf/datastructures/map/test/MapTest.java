package com.yusuf.datastructures.map.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    private static int size = 50_000_000;

    public static void main(String[] args) {

        /* It may not be accurate to compare them as HashMap , LinkedHashMap and TreeMap serve different uses. */

//        hashMapInsertion();// Average for 10 million integer key and value : 531.0 and 50 million integer key and value : 2762.0
//        linkedHashMapInsertion();// Average for 10 million integer key and value : 588.0 and 50 million integer key and value : 3158.0
//        treeMapInsertion();// Average for 10 million integer key and value : 1724.0 and 50 million integer key and value : 7868.0

    }

    public static void hashMapInsertion() {

        /*What is HashMap, its time complexity and how does it work?

        HashMap is a data structure used to quickly map key-value pairs in Java programming language. It uses an indexing
        mechanism based on keys and provides fast access to elements.

        The time complexity of HashMap is O(1), which means that operations such as searching, inserting, and deleting
        elements take constant time on average. However, in worst-case scenarios, its complexity can be O(n). This can
        happen when all elements have the same hash value and are placed in the same index, which would cause the
        HashMap to behave like a list and perform operations in linear time.

        How does HashMap work?

        * First, HashMap creates an array to store the data.
        * The hash value of the keys is calculated using a special hash function.
        * The hash value is then reduced to an index based on the size of the array.
        * The data is stored in the array at the calculated index.
        * When a new key-value pair is added, its hash value is calculated, and it is added to the array.
        * When a search is performed, the index is found by calculating the hash value of the key, and the element is retrieved from the array.
        * When an element is deleted, the index is found by calculating the hash value of the key, and the element is deleted from the array.
        This way, HashMap quickly maps key-value pairs and provides fast access to data.*/

        /*
        HashMap insertion process in Java is performed using the put() method, which adds a key-value pair to the HashMap
         data structure. The steps involved in adding a key-value pair to a HashMap are as follows:

        1- First, the hash code of the added key is calculated. This calculation is done using the hashCode() method.

        2- The hash code is used to determine a position in the hash table. This position is determined by taking the
         modulus of the hash code.

        3- A bucket is created in the specified position in the hash table. The bucket is a data structure that will store
         the key-value pairs, such as a LinkedList or a Tree.

        4- If the bucket at the specified position is empty, a new key-value pair is added to the bucket. If the bucket
        already contains one or more key-value pairs, the new key-value pair is added to the existing ones using a
        LinkedList or Tree data structure.

        5- Once the key-value pair is added to the bucket, it is considered to be added to the HashMap.

        In summary, adding a key-value pair to a HashMap involves calculating the hash code of the key, determining a
        position in the hash table, creating a bucket in that position, and adding the key-value pair to the bucket.
        This process is repeated until the key-value pair is added to the HashMap. If there is already a value associated
        with the same key, the new value overwrites the old one.
        */
        Map<Integer, Integer> integers = new HashMap<>();
        double start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            integers.put(i, i);
        }
        double end = System.currentTimeMillis();
        System.out.println("Time for HashMap is " + (end - start));
    }

    public static void linkedHashMapInsertion() {
        /*
        In Java, LinkedHashMap is a data structure for key-value pairs that is derived from the HashMap class. LinkedHashMap
         uses the same basic logic as HashMap, but it also remembers the insertion order.

        Unlike HashMap, LinkedHashMap maintains the order in which key-value pairs are added. Each key-value pair added to
        the LinkedHashMap is placed in the next position in the data structure. Therefore, LinkedHashMap is used when the
        order in which elements are added is important.

        In addition, LinkedHashMap ensures that the key-value pairs are returned in the order in which they were inserted
        when iterating through them using an Iterator or for-each loop. This means that LinkedHashMap is useful in
        applications where elements need to be returned in a predetermined order.

        Another important difference is that LinkedHashMap uses slightly more memory than HashMap. LinkedHashMap keeps an
        array or vector of the same size as a HashMap and uses a doubly linked list that stores the references to the
        previous and next elements for each element.

        In summary, LinkedHashMap is a data structure that maintains the insertion order of key-value pairs, unlike HashMap.
        Therefore, it is used when the order in which elements are added is important. In addition, LinkedHashMap's ability
        to return elements in the order in which they were added and its use of a doubly linked list for memory usage differ from HashMap.



        How does the insertion process work in LinkedHashMap?

        In LinkedHashMap, adding a key-value pair is done using the put() method, just like in HashMap. The put() method
        of LinkedHashMap follows the following steps to add the inserted key-value pair to the LinkedHashMap:

        First, the hash code of the added key is calculated using the hashCode() method.

        The calculated hash code is used to determine a position in the LinkedHashMap by taking the modulo of the hash code.

        A bucket is created at the determined position to store the key-value pairs. Unlike HashMap, LinkedHashMap uses
        a doubly linked list that stores the references to the previous and next buckets for each bucket, to remember
        the order of insertion.

        If the bucket at the determined position is empty, the new key-value pair is added to the bucket. If the bucket
        already contains one or more key-value pairs, the new key-value pair is added along with the existing ones using
        a linked list or tree structure.

        Once the key-value pair has been added to the bucket, it is considered to be added to the LinkedHashMap.

        These steps are followed during the insertion of a key-value pair in LinkedHashMap. As LinkedHashMap remembers
        the order of insertion, the added key-value pairs are inserted into the data structure at the next position, and
        subsequent operations are performed based on this order.

        In summary, adding a key-value pair to LinkedHashMap is done using the put() method, which involves calculating
        the hash code, determining the position, creating a bucket, and adding the key-value pair to the bucket. The
        added key-value pairs are stored in the order of insertion, and subsequent operations are performed based on this order.
        */

        Map<Integer, Integer> integers = new LinkedHashMap<>();
        double start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            integers.put(i, i);
        }
        double end = System.currentTimeMillis();
        System.out.println("Time for LinkedHashMap is " + (end - start));
    }

    public static void treeMapInsertion() {
        /*
        TreeMap is a data structure in the Java programming language. It is used to store key-value pairs, and the keys
        are stored in natural order. Therefore, TreeMap is used in situations where the keys need to be sorted.

        TreeMap uses a tree structure to store the data. The key-value pairs are stored in the tree structure according
        to the natural order of the keys. The insertion, deletion, and search operations of key-value pairs have a time
        complexity of O(log n) due to the natural order of the keys.

        TreeMap is useful especially in situations where sorting of keys is required. For example, if you want to count
        the number of words in a text document, you can use TreeMap. TreeMap can also be used to store keys as a number
        or string and sort them according to natural order.

        However, TreeMap also has some disadvantages compared to HashMap. In particular, the insertion, deletion, and
        search operations of HashMap usually have a time complexity of O(1), which is faster than TreeMap. Additionally,
        TreeMap uses extra memory to sort keys.


        TreeMap and HashMap are two different data structures offered in the Java programming language. The main differences
        between the two structures are:

        Element ordering: HashMap does not store elements in a sorted order. Elements are stored in a random order. However,
        TreeMap stores elements in a sorted order based on their keys.

        Performance: HashMap is optimized for fast access to elements. Elements can be accessed in O(1) time complexity.
        However, TreeMap may take more time to access elements since they are stored in a sorted order based on their keys.
        Elements can be accessed in O(log n) time complexity.

        Memory usage: HashMap uses less memory to store elements. This is because it does not need to perform as many
        operations or use as much memory as TreeMap, which stores elements in a sorted order based on their keys.

        Iterator order: Since HashMap stores elements in a random order, the order of elements returned by an iterator
        can be in any order. However, since TreeMap stores elements in a sorted order based on their keys, the order of
        elements returned by an iterator will be in their natural key order.

        In summary, the main differences between TreeMap and HashMap are based on element ordering, performance, memory
        usage, and iterator order. Therefore, you should choose the appropriate data structure based on your specific needs.
        If you need elements to be stored in a sorted order, TreeMap may be more suitable. However, if performance and
        memory usage are more important, HashMap may be a better choice.
        */

        Map<Integer, Integer> integers = new TreeMap<>();
        double start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            integers.put(i, i);
        }
        double end = System.currentTimeMillis();
        System.out.println("Time for TreeMap is " + (end - start));
    }
}