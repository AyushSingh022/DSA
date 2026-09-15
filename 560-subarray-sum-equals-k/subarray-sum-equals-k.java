class Solution {
    public int subarraySum(int[] arr, int k) {
        int sum=0;
        Map<Integer,Integer>mp=new HashMap<>();
        int cnt=0;
        mp.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int remove=sum-k;
            if(mp.containsKey(remove)){
                cnt+=mp.get(remove);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}