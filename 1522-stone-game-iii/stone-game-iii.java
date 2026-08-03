class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int a1=0;
        int a2=0;
        int a3=0;
        int x= 0;
        for (int i=stoneValue.length-1;i>=0;i--) {
            x+=stoneValue[i];
            int c =x-Math.min(a1,Math.min(a2, a3));
            a3=a2;
            a2=a1;
            a1=c;
        }
        int bob=x-a1;
        if (a1 > bob) {
            return "Alice";
        }
        if (a1<bob) {
            return "Bob";
        }
        return "Tie";
    }
}