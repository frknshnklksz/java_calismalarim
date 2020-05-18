package com.EmreAltunbilek.Collection.Set_Interface;

import com.sun.source.tree.Tree;

import java.util.Iterator;

/*
---------------------- TREE SET ----------------------
******************************************************
-> elemanları sırası nasılsa o şekilde gösterir. Yani sıralar öyle gösterir.
-> Arka tarafta tree map kullanır.
 */
public class TreeSet {
    public static void main(String[] args) {
        java.util.TreeSet<String> treeSet = new java.util.TreeSet<>();
        treeSet.add("a");
        treeSet.add("1");
        treeSet.add("b");
        treeSet.add("a");
        treeSet.add("a");
        treeSet.add("c");
        treeSet.add("c");
        treeSet.add("z");
        treeSet.add("w");
        treeSet.add("e");
        treeSet.add("k");
        System.out.println(treeSet);

        Object[] geciciDizi = treeSet.toArray();
        System.out.println(geciciDizi[5].toString());

        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
    }
}
