package tool.array;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class DynamicArray<R> {

    private static final int DEFAULT_SIZE = 10;

    private R[] objects;

    @SuppressWarnings("unchecked")
    public DynamicArray(int n) {
        objects = (R[]) new Object[n];
    }

    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    public void add(R r) {
        if (objects.length == getElementsCount()) {
            increaseArray();
        }
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = r;
                break;
            }
        }
    }

    public void remove(int index) {
        objects[index] = null;
        if (getLinkedUnusedCellsCount() > objects.length / 0.1) {
            decreaseArray();
        }
    }

    public R get(int index) {
        if (objects.length <= index) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + objects.length);
        }
        return objects[index];
    }

    public String toString() {
        return Arrays.stream(objects).map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
    }

    private long getElementsCount() {
        return Arrays.stream(objects).filter(Objects::nonNull).count();
    }

    private int getLinkedUnusedCellsCount() {
        int counter = 0;
        for (int i = objects.length - 1; i > 0; i--) {
            if (objects[i] == null) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private void increaseArray() {
        objects = Arrays.copyOf(objects, (int) (objects.length * 1.1));
    }

    private void decreaseArray() {
        objects = Arrays.copyOf(objects, (int) (objects.length * 0.9));
    }
}
