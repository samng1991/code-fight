import java.util.Arrays;
import java.util.HashMap;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int p1 = 0, p2 = 0, preV = 0, count = 0;
        while (count < len / 2) {
            if (p1 < nums1.length && p2 < nums2.length && nums1[p1] <= nums2[p2]) {
                preV = nums1[p1];
                p1++;
            } else if (p2 < nums2.length) {
                preV = nums2[p2];
                p2++;
            } else {
                preV = nums1[p1];
                p1++;
            }
            count++;
        }
        /**
         * Bitwise AND (&) –
         * This operator is binary operator, denoted by ‘&’. It returns bit by bit AND of input values, i.e, if both bits are 1, it gives 1, else it gives 0.
         * For example,
         * a = 5 = 0101 (In Binary)
         * b = 7 = 0111 (In Binary)
         *
         * Bitwise AND Operation of 5 and 7
         *   0101
         * & 0111
         *  ________
         *   0101  = 5 (In decimal)
         */
        /**
         * Check even or odd
         *   0111 = 7
         * & 0001 = 1
         *  ________
         *   0001  = 1(odd)
         *
         *   0110 = 6
         * & 0001 = 1
         *  ________
         *   0001  = 0(even)
         */
        // check if it is even
        if ((len & 1) == 0) {
            if (p1 < nums1.length && p2 < nums2.length) {
                return nums1[p1] <= nums2[p2] ? (preV + nums1[p1]) / (double) 2 : (preV + nums2[p2]) / (double) 2;
            }
            if (p1 < nums1.length) {
                return (preV + nums1[p1]) / (double) 2;
            }
            return (preV + nums2[p2]) / (double) 2;
        } else {
            if (p1 < nums1.length && p2 < nums2.length) {
                return nums1[p1] <= nums2[p2] ? nums1[p1] : nums2[p2];
            }
            if (p1 < nums1.length) {
                return nums1[p1];
            }
            return nums2[p2];
        }
    }

    public static void main(String args[]) throws Exception {
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 5}, new int[]{10, 100}));
        System.out.println(findMedianSortedArrays(new int[]{0, 10, 100, 200}, new int[]{30, 50}));
    }

}
