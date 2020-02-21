package com.company;

public class MyHashSet implements MySet {

    private MyHashMap map = new MyHashMap();

    private final String PLACEHOLDER = "";

    @Override
    public boolean add(String value) {
        map.put(value, PLACEHOLDER);
        return true;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean remove(String value) {
        return map.remove(value) != null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean contains(String value) {
        return map.contains(value);
    }

    @Override
    public String[] toArray() {
        // TODO implement
        return new String[0];
    }

    @Override
    public String toString() {
        // TODO implement
        return map.toString();
    }
}