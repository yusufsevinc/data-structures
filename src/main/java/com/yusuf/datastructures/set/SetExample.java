package com.yusuf.datastructures.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {

        /*The Java Set is a part of the Java Collections Framework and allows for the storage and organization of
        multiple elements. The Set interface is derived from the Collection interface and ensures that there are no
        duplicate elements. That is, the same element cannot occur more than once in a Set object.*/

        /*Some of the most common use cases for the Java Set interface are:

         1- Preventing duplicates: The Set interface guarantees that there are no duplicates, improving the quality and
         accuracy of the data structure.
         2- Creating sets: The Set interface allows for the storage of elements in a set form, and allows for operations
         such as difference and similarity between sets.
         3- Filtering data: The Set interface can be used to filter data and retrieve selected data based on a specific criterion.*/

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4, 5));

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union of sets: " + union);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection of sets: " + intersection);

        Set<Integer> setOne = new HashSet<>(set1);
        setOne.removeAll(set2);
        System.out.println("Difference of sets (Set1 - Set2): " + setOne);

        Set<Integer> setTwo = new HashSet<>(set2);
        setTwo.removeAll(set1);
        System.out.println("Difference of sets (Set2 - Set1): " + setTwo);
    }
}
