package core.basesyntax;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] myData;
    private int size;

    public ArrayList() {
        myData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T value) {
        if (size == myData.length) {
            myData = Arrays.copyOf(myData, myData.length + myData.length / 2);
        }
        myData[size] = value;
        size++;
    }

    @Override
    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new ArrayListIndexOutOfBoundsException("...");
        }
        if (size == myData.length) {
            myData = Arrays.copyOf(myData, myData.length + myData.length / 2);
        }
        for (int i = size - 1; i >= index; i--) {
            myData[i + 1] = myData[i];
        }
        myData[index] = value;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException("...");
        }
        return (T) myData[index];
    }

    @Override
    public void set(T value, int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException("...");
        }
        myData[index] = value;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException("...");
        }
        final T removed = (T) myData[index];
        for (int i = index + 1; i < size; i++) {
            myData[i - 1] = myData[i];
        }
        myData[size - 1] = null;
        size--;
        return removed;
    }

    @Override
    public T remove(T element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (myData[i] == null && element == null
                    || myData[i] != null && myData[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new NoSuchElementException("...");
        }
        return remove(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }
}
