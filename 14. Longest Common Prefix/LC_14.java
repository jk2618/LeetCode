public class LC_14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String LCP = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            String currentString = strs[i];

            while (j < Math.min(LCP.length(), currentString.length()) && LCP.charAt(j) == currentString.charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            LCP = LCP.substring(0, j);
        }
        return LCP;
    }
