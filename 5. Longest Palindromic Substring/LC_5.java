public class LC_5 {
    public static String longestPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        int length = str.length();
        boolean[][] isPalindrome = new boolean[length][length]; 
        int left = 0;
        int right = 0;
        
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                boolean isInnerPalindrome = isPalindrome[i + 1][j - 1] || j - i <= 2;
                if (str.charAt(i) == str.charAt(j) && isInnerPalindrome) {
                    isPalindrome[i][j] = true;
                    if (j - i > left - right) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return str.substring(left, right + 1);
    }
