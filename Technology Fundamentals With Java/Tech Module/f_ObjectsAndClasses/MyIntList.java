package f_ObjectsAndClasses;

public class MyIntList {
    private static final int DEFAULT = 10;
    private int[] array;
    private int currentIndex;
    private int size;

    public MyIntList() {
        this.array = new int[DEFAULT];
        this.currentIndex = 0;
        this.size = 0;
    }

    public void add(int i) {
        if (size == currentIndex) {
            this.arrayCopy();
        }
        this.array[currentIndex] = i;
        currentIndex++;
        size++;

    }

    public int getSize() {
        return this.size;
    }

    public int get(int index){
        return this.array[index];
    }

    private void arrayCopy() {
        int[] temp = new int[this.array.length];
        for (int i = 0; i < this.array.length; i++) {
            temp[i] = this.array[i];
        }

        this.array = new int[this.array.length * 2];
        for (int i = 0; i < temp.length; i++) {
            this.array[i] = temp[i];
        }
    }
}
