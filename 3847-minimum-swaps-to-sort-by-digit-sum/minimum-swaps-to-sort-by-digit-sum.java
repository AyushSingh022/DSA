class Solution {

    int sumofDigit(int n) {
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> {
            int sa = sumofDigit(nums[a]);
            int sb = sumofDigit(nums[b]);

            if (sa != sb)
                return Integer.compare(sa, sb);

            return Integer.compare(nums[a], nums[b]);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || index[i] == i)
                continue;

            int j = i;
            int cycleSize = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = index[j];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }
}