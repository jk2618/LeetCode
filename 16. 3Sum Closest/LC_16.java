import java.util.Arrays;

public class LC_16 {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sums = nums[i] + nums[left] + nums[right];
                if (Math.abs(sums - target) < Math.abs(closest - target)) {
                    closest = sums;
                }
                if (sums < target) {
                    left++;
                }
                if (sums > target) {
                    right--;
                }
            }
        }
        return closest;
    }
}
