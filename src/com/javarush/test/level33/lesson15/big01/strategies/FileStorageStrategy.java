package com.javarush.test.level33.lesson15.big01.strategies;

/**
 * Created by Alexei on 24.01.2016.
 */
public class FileStorageStrategy implements StorageStrategy {

    private long bucketSizeLimit = 10000;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];

    int hash(Long k) {
        return k.hashCode();
    }

    int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public FileStorageStrategy() {
        for (FileBucket fileBucket : table) {
            fileBucket = new FileBucket();
        }
    }

    Entry getEntry(Long key) {
        if (table.length == 0) {
            return null;
        }
        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Long k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                return e;
            }
        }
        return null;
    }

    void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        for (FileBucket fileBucket : newTable) {
            fileBucket = new FileBucket();
        }
        transfer(newTable);
        table = newTable;
    }

    void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;
        for (FileBucket fileBucket : table) {
            if (fileBucket == null) continue;
            Entry e = fileBucket.getEntry();
            while (e != null) {
                Entry next = e.next;
                int i = indexFor(e.hash, newCapacity);
                if (newTable[i] == null) {
                    e.next = null;
                } else {
                    e.next = newTable[i].getEntry();
                }
                newTable[i].putEntry(e);
                e = next;
            }
            fileBucket.remove();
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
/*        long maxSizeFound = 0;
        for (FileBucket fileBucket : table) {
            if (fileBucket != null && fileBucket.getFileSize() > maxSizeFound) {
                maxSizeFound = fileBucket.getFileSize();
            }
        }
        if ((maxSizeFound > bucketSizeLimit)) {
            resize(2 * table.length);
            hash = (key != null) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);*/
        createEntry(hash, key, value, bucketIndex);
        if (table[bucketIndex].getFileSize() > bucketSizeLimit) {
            resize(2 * table.length);
        }
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, e));
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            for (Entry e = table[i].getEntry(); e != null; e = e.next)
                if (value.equals(e.value))
                    return true;
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        if (key == null) return;
        int hash = hash(key);
        int i = indexFor(hash, table.length);
/*        if (table[i] == null) {
            table[i] = new FileBucket();
        }*/
        for (Entry e = table[i].getEntry(); e != null; e = e.next) {
            Long k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                e.value = value;
                return;
            }
        }
        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fileBucket : table) {
            Entry e = fileBucket.getEntry();
            if (e != null) {
                if (e.getValue().equals(value)) return e.getKey();
            }
        }
        return null;

    }

    @Override
    public String getValue(Long key) {
        return getEntry(key) == null ? null : getEntry(key).getValue();
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }
}
