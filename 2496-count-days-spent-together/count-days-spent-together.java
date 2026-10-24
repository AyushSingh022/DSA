class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String a=arriveAlice.compareTo(arriveBob)>0?arriveAlice:arriveBob;
        String b=leaveAlice.compareTo(leaveBob)<0?leaveAlice:leaveBob;
        return Math.max(0,day(b)-day(a)+1);
    }
    static int[] before={0,31,28,31,30,31,30,31,31,30,31,30};
    static{
        Arrays.parallelPrefix(before,Integer::sum);
    }
    static int day(String mmdd){
        return before[Integer.parseInt(mmdd.substring(0,2))-1]+Integer.parseInt(mmdd.substring(3));
    }
}