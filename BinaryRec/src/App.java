import java.util.Random;

public class App {

    public static int binarySearch(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    public static void bubbleSort(int[] array) {
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

    private static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // target not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // target found
        }

        if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }

        return binarySearchRecursive(arr, target, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] random_num_array = new int[20];
        Random random = new Random();

        
        for (int i = 0; i < random_num_array.length; i++) {
            random_num_array[i] = random.nextInt(20);
        }

        System.out.println("Random 20 elements from the array:");
        for (int i = 0; i < 20; i++) {
            System.out.println(random_num_array[i]);
        }

        bubbleSort(random_num_array);

        System.out.println("Random Sorted 20 elements from the array:");
        for (int i = 0; i < 20; i++) {
            System.out.println(random_num_array[i]);
        }

        System.out.println("The value is at index : " + binarySearch(random_num_array, 12));
        

    }
}
