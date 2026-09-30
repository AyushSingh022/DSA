class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int[] ans=new int[n];
        int s=0;
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                ++s;
                ans[i]=s%2;
            }
            else{
                ans[i]=s%2;
                --s;
            }
        }
        return ans;
        
    }
}