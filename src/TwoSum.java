/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.Arrays;
import java.util.Hashtable;

public class TwoSum {
    public int[] twoSum(int[] listIn, int target) {

        Hashtable<Integer, Integer> h = new Hashtable<>();
        for (int i = 0; i < listIn.length; i++) {
            int tmp = target - listIn[i];
            if (h.containsKey(tmp)) {
                return new int[]{h.get(tmp), i};
            }
            h.put(listIn[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        int[] output = twoSum.twoSum(input, 13);
        System.out.println(Arrays.toString(output));
    }
}
