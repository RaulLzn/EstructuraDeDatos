package raul.hash.hashTable;

import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.array.Array;

public class HashTable<E> {
    Array<LinkedList<E>> table;
    int nearestPrime;

    public HashTable(int capacity) {
        this. nearestPrime = capacity;
        this. table = new Array<>(capacity);
        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<>());
        }
        previosPrime();
    }

    public void insert(int key, E value) {
        int index = key % nearestPrime;
        table.get(index).add(value);
    }





}
