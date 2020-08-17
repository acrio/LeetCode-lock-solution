class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(0)) dp[0][i] = i;
            else if (i > 0) dp[0][i] = dp[0][i - 1];
            else dp[0][i] = -1;
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = -1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1 ; j < n; j++) {
                if (i > j) dp[i][j] = -1;
                else {
                    if (t.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        int min = n;
        String rt = "";
        for (int i = 0; i < n; i++) {
            if (dp[m - 1][i] == -1) continue;
            if (min > i - dp[m - 1][i] + 1) {
                rt = s.substring(dp[m - 1][i], i + 1);
                min = i - dp[m - 1][i] + 1;
            }
        }

        return rt;
    }
}
