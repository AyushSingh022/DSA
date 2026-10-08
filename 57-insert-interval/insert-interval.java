
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean insert = false;
        int row = intervals.length;
        int col = 2;

        int[][] newintervals = new int[row + 1][col];
        int j = 0;

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (end < newInterval[0]) {
                newintervals[j++] = intervals[i];
            } else if (start > newInterval[1]) {
                if (!insert) {
                    newintervals[j++] = newInterval;
                    insert = true;
                }
                newintervals[j++] = intervals[i];
            } else {
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
            }
        }

        if (!insert) {
            newintervals[j++] = newInterval;
        }

        return java.util.Arrays.copyOf(newintervals, j);
    }
}