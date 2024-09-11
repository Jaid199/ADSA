public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        //randomNum();
        int[] array = new int[10000];
        for(int i = 0; i <= 10000 - 1; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }
        
        //bubbleSort(array); // 1200 nano sec
        //selectionSort(array); // 1300 nano sec
        insertionSort(array); // 1100 nano sec
        printArray(array);
        timeTaken(array);
    } 

    public static void selectionSort(int[] array) {
        // to move oone by one
        int num = array.length;
        for(int i = 0; i < num - 1; i++) {
            int min = i;
            for(int j = i + 1; j < num; j++) {
                if(array[j] < array[min]) {
                    min = j; // search for lowest index
                }
            }

            if(min != i) {
                // swap
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }

    // worse case big O(n^2)
    // best case big O(n)
    public static void bubbleSort(int[] array) {
        int num = array.length;
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        int length = array.length;
        for(int i = 0; i < length; i++) {
            int key = array[i]; // select a key
            int j = i - 1; // selected number to compare 

            // moves the elements
            while(j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
    // best case big O(n)
    // best case big O(n)
            array[j + 1] = key;
        }
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    public static void timeTaken(int[] array) {
        long start = System.nanoTime();
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Time taken: " + timeTaken + " nanoseconds");
    }
}