package n1exercise3;

public class ArrayOperations {

    private final int[] array;

    public ArrayOperations(int[] array) {
        this.array = array;
    }

    public int getElementAtIndex(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }
}
