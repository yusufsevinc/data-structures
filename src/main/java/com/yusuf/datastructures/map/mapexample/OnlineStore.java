package com.yusuf.datastructures.map.mapexample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OnlineStore {

        /*
        In Java, Map is an interface that stores key-value pairs. These pairs consist of a key and its associated value.
        The Map interface is a part of the Collections Framework and provides various features.

        Map can be used to store data and provide quick access to it later. It is particularly useful in the following scenarios:


        1- Data storage: Map can be used to store data in key-value pairs. Therefore, Map is often used in situations
        where data needs to be stored in a searchable, fast, and efficient manner.

        2- Counting operations: Map can be used for counting operations on data. For example, an application may need to
         count how many times a certain word is used, and a Map can be used to accomplish this.

        3- Relational data: Map can be used to express relationships between data, as it associates key-value pairs. For
         example, a Map can be created that stores a student's name corresponding to their student ID.

        4- Grouping operations: Map can be used for grouping data using unique keys. For example, an application can use
         a Map to group users with a unique username.

        In Java, Map is implemented by different classes such as HashMap, TreeMap, and LinkedHashMap. These classes have
         different data structures and performance characteristics, so they can be chosen based on the usage scenario.*/

    Map<Integer, Item> inventory = new HashMap<Integer, Item>();

    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();

        // Add items to inventory
        store.inventory.put(1, new Item("Shirt", 20.0, 50));
        store.inventory.put(2, new Item("Pants", 30.0, 30));
        store.inventory.put(3, new Item("Shoes", 50.0, 20));

        // Retrieve an item from inventory by ID
        int itemId = 1;
        Item item = store.inventory.get(itemId);
        if (item != null) {
            System.out.println("Item " + itemId + ": " + item.getName() + " - Price: " + item.getPrice() + " - Quantity: " + item.getQuantity());
        }

        // Update the quantity of an item in inventory
        itemId = 2;
        Item itemToUpdate = store.inventory.get(itemId);
        if (itemToUpdate != null) {
            itemToUpdate.setQuantity(40);
            System.out.println("Updated item " + itemId + ": " + itemToUpdate.getName() + " - Price: " + itemToUpdate.getPrice() + " - Quantity: " + itemToUpdate.getQuantity());
        }

        // Remove an item from inventory
        itemId = 3;
        store.inventory.remove(itemId);
        System.out.println("Removed item " + itemId + " from inventory.");

        //Item List
        Iterator<Map.Entry<Integer, Item>> iterator = store.inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Item> next = iterator.next();
            System.out.println("item " + next.getKey() + ": " + next.getValue().getName() + " - Price: " + next.getValue().getPrice() + " - Quantity: " + next.getValue().getQuantity());
        }
    }
}

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
