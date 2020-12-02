package tool.array;

import java.util.Arrays;
import java.util.Objects;

public class DynamicDoubleArray {

    private Double[] array;

    public DynamicDoubleArray(int n) {
        array = new Double[n];
    }

    public DynamicDoubleArray() {
        this(10);
    }

    public void add(Double number) {
        if (array.length == getElementsCount()) {
            increaseArray();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = number;
                break;
            }
        }
    }

    public void remove(int index) {
        array[index] = null;
        if (getLinkedUnusedCellsCount() > array.length / 0.1) {
            decreaseArray();
        }
    }

    public Double get(int index) {
        if (array.length <= index) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
        }
        return array[index];
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            double value = (array[i] == null) ? 0 : array[i];
            if (i == array.length - 1) {
                stringBuilder.append(value);
                break;
            }
            stringBuilder.append(value).append(", ");
        }
        return stringBuilder.append("]").toString();
    }

    private long getElementsCount() {
        return Arrays.stream(array).filter(Objects::nonNull).count();
    }

    private int getLinkedUnusedCellsCount() {
        int counter = 0;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == null) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private void increaseArray() {
        array = Arrays.copyOf(array, (int) (array.length * 1.1));
    }

    private void decreaseArray() {
        array = Arrays.copyOf(array, (int) (array.length * 0.9));
    }
}
