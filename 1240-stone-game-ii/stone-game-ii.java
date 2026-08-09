class Solution {
     int[][] memo;
     int[] suffix;
     int n;
    public int stoneGameII(int[] piles) {
        n=piles.length;
        suffix= new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i]=suffix[i + 1]+piles[i];
        }
        memo=new int[n][n + 1];
        return dfs(0, 1);
    }
     int dfs(int i, int m) {
        if (i >= n)
            return 0;
        if (2*m>=n-i)
            return suffix[i];
        if (memo[i][m]!=0)
            return memo[i][m];
        int best = 0;
        for (int j =1;j<=2*m; j++) {
            best = Math.max(
                    best,
                    suffix[i] - dfs(i + j,Math.max(m, j))
            );
        }
        memo[i][m] = best;
        return best;
    }
}