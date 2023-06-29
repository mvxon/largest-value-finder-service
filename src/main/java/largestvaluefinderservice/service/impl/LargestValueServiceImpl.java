package largestvaluefinderservice.service.impl;

import java.util.Random;
import largestvaluefinderservice.service.LargestValueService;

public class LargestValueServiceImpl implements LargestValueService {

    /**
     * Finds the n-th largest number in the given integer array.
     *
     * @param numbers the integer array in which to find the n-th largest number
     * @param n the ordinal number of the maximum number to be found
     * @return the n-th largest number in the array
     * @throws IllegalArgumentException if the input array is null, empty, or if n is out of range
     */
    @Override
    public int getLargestValue(int[] numbers, int n) {
        if (numbers == null || numbers.length == 0 || n <= 0 || n > numbers.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        quickSort(numbers, 0, numbers.length - 1);

        return numbers[numbers.length - n];
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int randomIndex = new Random().nextInt(high - low + 1) + low;
        swap(array, randomIndex, high);

        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
