/*
 * Generate 10,000 random numbers and calculate the time taken to sort
 * them using Insertion, Sort Selection Sort and Random Sort.
 */
import java.util.Random;

public class SortingAlgorithmTutorial {
    public static void main(String[] args) throws Exception {
        int[] random_num_array = new int[10000];
        Random random = new Random();

        // GENERATING RANDOM NUMS AND STORING THEM IN ARRAY
        for (int i = 0; i < random_num_array.length; i++) {
            random_num_array[i] = random.nextInt();
        }

        // CREATING DUPLICATES OF THE GENERATED ARRAY TO MAINTAIN CONSISTENCY
        int[] random_num_array_2 = random_num_array.clone();
        int[] random_num_array_3 = random_num_array.clone();

        // INSERTION SORT BENCHMARK
        System.out.println("INSERTION SORT:");
        long start_time = System.nanoTime(); // START TIMER
        insertionSort(random_num_array);
        long end_time = System.nanoTime(); // END TIMER
        calculateTimeTaken(start_time, end_time);
        
        // SELECTION SORT BENCHMARK
        System.out.println("SELECTION SORT:");
        long start_time_2 = System.nanoTime(); // START TIMER 2
        selectionSort(random_num_array_2);
        long end_time_2 = System.nanoTime(); // END TIMER 2
        calculateTimeTaken(start_time_2, end_time_2);
        
        // BUBBLE SORT BENCHMARK
        System.out.println("BUBBLE SORT:");
        long start_time_3 = System.nanoTime(); // START TIMER 3
        bubbleSort(random_num_array_3);
        long end_time_3 = System.nanoTime(); // END TIMER 3
        calculateTimeTaken(start_time_3, end_time_3);
        
    }

    // INSERTION SORT
    static void insertionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // SELECTION SORT
    static void selectionSort(int[] array) {
        for (int i = 0; i > array.length; i++) {
            int min_index = i;
            for (int j = 0; j < array.length; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }

            // SWAPS IF SECOND VALUE IS GREATER THAN MIN (FIRST) VALUE
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
    }

    // BUBBLE SORT
    static void bubbleSort(int[] array) {
        int temp;
        boolean swapped;

        for (int i = 0; i < array.length - 1; i++){
            swapped = false;

            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];            // STORE FIRST VALUE IN TEMP
                    array[j] = array[j + 1];    // MOVE SECOND VALUE TO FIRST POSITION
                    array[j + 1] = temp;        // SET SECOND VALUE TO TEMP VALUE 
                    swapped = true;
                }
            }

            if (swapped == false) {             // IF SWAPPED IS FALSE IT MEANS NO ELEMENTS WERE SWAPPED AND THE ARRAY IS SORTED
                break;
            }
        }
    }

    // METHOD TO CALCULATE TIME TAKEN
    static void calculateTimeTaken(long startTime, long endTime) {
        long duration = endTime - startTime; // Time in nanoseconds
        double milliseconds = duration / 1_000_000.0; // Convert to milliseconds
        System.out.println("Time taken: " + milliseconds + " ms");
    }
}
