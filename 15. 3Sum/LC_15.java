import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // when the target has repeated values, move to the next
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            twoSumHelper(nums, results, target, left, right);
        }
        return results;
    }

    private static void twoSumHelper(int[] nums, List<List<Integer>> results, int target, int left, int right) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> triple = new ArrayList<>();
                triple.add(target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);

                left++;
                right--;
                
                // when there are repeated values, e.g. [-4, -1, -1, 0, 1, 2], move to the next
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                // when there are repeated values, move to the next
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            }
        }
    }
}    
