import java.util.HashSet;

public class LC_3 {
    public static int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        int i = 0;
        int j = 0;

        HashSet<Character> set = new HashSet<>();
        while (j < str.length()) {
            if (!set.contains(str.charAt(j))) {
                set.add(str.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(str.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
