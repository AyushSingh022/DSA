class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> pos=new ArrayList<>();
        List<Integer> neg=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }
        int n=pos.size();
        int m=neg.size();
        for(int i=0;i<n;i++){
            pos.set(i,pos.get(i)*pos.get(i));
        }
        for(int i=0;i<m;i++){
             neg.set(i,neg.get(i)*neg.get(i));
        }
        Collections.reverse(neg);
        int i=0;
        int j=0;
        int index=0;
        int ans[]=new int[n+m];
        while(i<n && j<m){
            if(pos.get(i)<neg.get(j)){
                ans[index++]=pos.get(i++);
            }
            else{
                ans[index++]=neg.get(j++);
            }
        }
        while(i<n){
            ans[index++]=pos.get(i++);
        }
        while(j<m){
            ans[index++]=neg.get(j++);
        }
        return ans;
    }
}