package largestvaluefinderservice.service;

public interface LargestValueService {

    /**
     * Finds the n-th largest number in the given integer array.
     *
     * @param numbers the integer array in which to find the n-th largest number
     * @param n the ordinal number of the maximum number to be found
     * @return the n-th largest number in the array
     * @throws IllegalArgumentException if the input array is null, empty, or if n is out of range
     */
    int getLargestValue(int[] numbers, int n);
}
