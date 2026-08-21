class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        long lo = 1;
        long hi = (long) 1e18;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (count(mid, coins, n) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private long count(long x, int[] coins, int n) {
        long ans = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    long g = gcd(lcm, coins[i]);

                     if (lcm > x / (coins[i] / g)) {
                        overflow = true;
                        break;
                    }

                    lcm = lcm / g * coins[i];

                    if (lcm > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (overflow) continue;

            long multiples = x / lcm;

            if (Integer.bitCount(mask) % 2 == 1) {
                ans += multiples;
            } else {
                ans -= multiples;
            }
        }

        return ans;
    }

     long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}