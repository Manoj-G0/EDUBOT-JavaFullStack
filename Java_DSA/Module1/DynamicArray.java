import java.util.Arrays;

public class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        this.capacity = 10;
        this.array = new int[capacity];
        this.size = 0;
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        this.capacity = initialCapacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        array[index] = element;
    }
    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == capacity) {
            resizeArray();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }
    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int deletedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deletedElement;
    }

    public int find(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1; 
    }
    public void sort() {
        Arrays.sort(array, 0, size);
    }

    public void merge(DynamicArray otherArray) {
        if (this.size + otherArray.size() > this.capacity) {
            int newCapacity = Math.max(this.capacity * 2, this.size + otherArray.size());
            int[] newArray = new int[newCapacity];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            this.array = newArray;
            this.capacity = newCapacity;
        }
        for (int i = 0; i < otherArray.size(); i++) {
            this.array[this.size + i] = otherArray.get(i);
        }
        this.size += otherArray.size();
    }
    public void reverse() {
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    private void resizeArray() {
        int newCapacity = this.capacity * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(this.array, 0, newArray, 0, this.size);
        this.array = newArray;
        this.capacity = newCapacity;
    }

    public void print() {
        System.out.print("DynamicArray: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();
        arr.insert(0, 10);
        arr.insert(1, 20);
        arr.insert(2, 30);
        arr.print(); 

        arr.delete(1);
        arr.print(); 

        arr.insert(1, 40);
        arr.print();

        System.out.println("Index of 40: " + arr.find(40)); 

        arr.sort();
        arr.print(); 

        DynamicArray arr2 = new DynamicArray();
        arr2.insert(0, 20);
        arr2.insert(1, 30);
        arr.merge(arr2);
        arr.print(); 

        arr.reverse();
        arr.print(); 
    }
}
