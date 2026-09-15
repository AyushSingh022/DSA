class Solution {
    public int maxPalindromes(String s2, int k) {
        int n = s2.length();
        int end = 0;
        int cnt = 0;

        for (int i = 0; i < 2 * n; i++) {
            int s = i / 2;
            int e = s + i % 2;

            while (s >= 0 && e < n) {
                if (s2.charAt(s) != s2.charAt(e)) {
                    break;
                }

                if (e - s + 1 >= k) {
                    if (s >= end) {
                        cnt++;
                        end = e + 1;
                    }
                    break;
                }

                s--;
                e++;
            }
        }

        return cnt;
    }
}