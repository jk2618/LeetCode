public class LC_5 {
    public static String longestPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        int length = str.length();
        // upon initialization, Java sets default values to false
        boolean[][] isPalindrome = new boolean[length][length]; 
        int left = 0;
        int right = 0;
        
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                boolean isInnerPalindrome = isPalindrome[i + 1][j - 1] || j - i <= 2;
                if (str.charAt(i) == str.charAt(j) && isInnerPalindrome) {
                    isPalindrome[i][j] = true;
                    // this is to memorize the longest length of indexes
                    // it occurs only when str[i] == str[j] && isInnerPalindrome both are true
                    if (j - i > left - right) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return str.substring(left, right + 1);
    }
