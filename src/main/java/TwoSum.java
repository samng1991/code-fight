import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int complement;
        //loop to check every element in the array
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            //if we already have the complement in HashMap,
            //return an array that contains indices of them.
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            //if its complement is not in HashMap but in the array,
            //they will be matched when the complement is
            //regarded as current element.
            //add current element into HashMap.
            map.put(nums[i], i);
        }
        //Exception which says it is unavailable to find solution
        //with these arguments.
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String args[]) throws Exception {
        int[][] exampleArray = new int[][]{
                new int[]{2, 7, 11, 15},
                new int[]{15, 7, 4, 9, 0},
                new int[]{-2, -7, 11, 15}
        };
        int[] exampleTarget = new int[]{
                9, 9, 9
        };

        for (int i = 0; i < exampleArray.length; i++) {
            System.out.println(Arrays.toString(twoSum(exampleArray[i], exampleTarget[i])));
        }
    }

}
