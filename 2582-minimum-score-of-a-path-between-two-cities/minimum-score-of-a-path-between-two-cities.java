class Solution {
    static int find(int[] res,int n){
        if(res[n]==n){
            return n;
        }
        return res[n]=find(res,res[n]);
    }
    public int minScore(int n, int[][] roads) {
       int[] root=new int[n+1];
       for(int i=0;i<=n;i++){
        root[i]=i;
       }
       for(int[] r:roads){
        root[find(root,r[0])]=find(root,r[1]);
       }
       int res=10001;
       for(int[] r:roads){
        if(find(root,r[0])==find(root,1)){
            res=Math.min(res,r[2]);
        }
       }
       return res;
        
    }
}