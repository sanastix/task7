package com.company;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.util.Objects.hash;

public class MyHashMap implements MyMap {

    private static class Entry implements MyMap.Entry {

        String key;
        String value;
        Entry next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return Objects.equals(key, entry.key) &&
                    Objects.equals(value, entry.value) &&
                    Objects.equals(next, entry.next);
        }

        @Override
        public int hashCode() {
            return hash(key, value, next);
        }

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String setValue(String value) {
            String oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }
    }

    private int size = 0;
    private static Entry[] table = new Entry[16];
    private double loadFactor = 0.75;
    private int threshold = (int) (table.length * loadFactor);
    private int capacity = table.length;

    public MyHashMap() {
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
    }

    public MyHashMap(double loadFactor, int capacity) {
        this.loadFactor = loadFactor;
        this.capacity = capacity;
    }

    @Override
    public String put(String key, String value) {
        Entry newEntry = new Entry(key, value);
        if (size > threshold) {
            resize();
        }
        int index = Math.abs(key.hashCode()) % (table.length - 1);
        if (table[index] == null) {
            table[index] = newEntry;
            size++;
        } else  if ((table[index].hashCode() == newEntry.hashCode()) && newEntry.equals(table[index])){
            Entry oldValue = table[index];
            table[index] = newEntry;
            newEntry.next = oldValue;
            size++;
            return String.valueOf(oldValue);
        }
        return null;
    }

    private void resize() {
        int newCapacity = table.length*3/2;
        Entry[] newTable = new Entry[newCapacity];
        Entry[] tmp = table;
        for (Entry e : tmp) {
            int index = Math.abs(e.hashCode()) % (newTable.length - 1);
            if (newTable[index] == null) {
                newTable[index] = e;
            } else if ((newTable[index].hashCode() == e.hashCode()) && e.equals(newTable[index])) {
                Entry oldValue = newTable[index];
                newTable[index] = e;
                e.next = oldValue;
            }
        }
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    @Override
    public String get(String key) {
        return getting(key);
    }

    @Override
    public boolean contains(String key) {
        return getting(key) != null;
    }

    @Override
    public void clear() {
        size = 0;
        table = new Entry[16];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String remove(String key) {
        String tmp = "";
        if (getting(key) == null) {
            return null;
        } else {
            tmp = getting(key);
        }
        String result = tmp;
        result = null;
        return tmp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<MyMap.Entry> entrySet() {
        Set<MyMap.Entry> result = new HashSet<>();
        for (Entry entry : table) {
            Entry tmpEntry = entry;
            while (tmpEntry != null) {
                result.add(tmpEntry);
                tmpEntry = tmpEntry.next;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return entrySet().toString();
    }

    @Override
    public Entry[] toArray() {
        Entry[] result = new Entry[size];
        int index = 0;
        for (Entry tmp : table) {
            while (tmp != null) {
                result[index] = tmp;
                tmp = tmp.next;
                index++;
            }
        }
        return result;
    }

    private static String getting(String key) {
        int index = Math.abs(key.hashCode()) % (table.length - 1);
        String result = "";
        if (table[index] == null) {
            return null;
        } else {
            for (Entry e = table[index]; e != null; e = e.next) {
                if (e.hashCode() == key.hashCode() && (result = e.key).equals(key))
                    result = e.value;
            }
        }
        return result;
    }

}