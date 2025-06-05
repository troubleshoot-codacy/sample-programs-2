import java.util.Arrays
import groovy.transform.CompileStatic

/**
 * Implementation of Merge Sort algorithm in Groovy
 */
@CompileStatic
class MergeSort {

    public static final String NAME = 'Merge Sort'
    public static final String DESCRIPTION = 'Sorts an array using the Merge Sort algorithm, which is a divide-and-conquer algorithm that sorts in O(n log n) time and O(n) space.'
    public static final String COMPLEXITY = 'O(n log n) time, O(n) space'
    public static final String STABILITY = 'Stable'
    /**
     * Public entry point for sorting an array
     * @param data Array to sort
     * @return void
     */
    public static void sort(int[] data) {
        sort(data, 0, data.length - 1)
    }

    /**
     * Sorts the range data[start..end] in O(nlgn) time and O(n) space.
     * @param data Array to sort
     * @param start Start index
     * @param end End index
     * @return void
     */
    private static void sort(int[] data, int start, int end) {
        if (end > start) {
            // Prevent integer overflow
            int middle = start + (end - start) / 2

            // Sort the left and right sides separately.
            sort(data, start, middle)
            sort(data, middle + 1, end)

            // Intertwine the data into one sorted list.
            mergeLists(data, start, middle, end)
        }
    }

    /**
     * Merges the two sorted sublists of data[start..middle] and data[middle+1..end].
     * O(n) time and memory.
     * @param data Array containing the sublists
     * @param start Start index
     * @param middle Middle index
     * @param end End index
     * @return void
     */
    private static void mergeLists(int[] data, int start, int middle, int end) {
        // Copy the left and right arrays because we'll be overwriting them.
        int[] left = Arrays.copyOfRange(data, start, middle + 1)
        int[] right = Arrays.copyOfRange(data, middle + 1, end + 1)

        // Now, merge the lists by repeatedly adding the biggest value, from whichever list has it.
        int i = start
        int l = 0
        int r = 0 
        
        while (l < left.length && r < right.length) {
            data[i++] = (left[l] <= right[r]) ? left[l++] : right[r++]
        }

        // Add any leftovers on one side.
        while (l < left.length) {
            data[i++] = left[l++]
        }
        while (r < right.length) {
            data[i++] = right[r++]
        }
    }

    /**
     * Main entry point
     * @param args Command line arguments
     * @return void
     */
    public static void main(String[] args) {
        if (args == null || args.length < 2 || !args.every { it.isInteger() }) {
            println 'Usage: please provide a list of at least two integers to sort'
            return
        }
        
        try {
            def argsint = args.collect { it as int } as int[]
            sort(argsint)
            println(Arrays.toString(argsint))
        } catch (NumberFormatException e) {
            println 'Usage: please provide a list of at least two integers to sort'
        }
    }
}