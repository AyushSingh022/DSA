class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] last=new int[m];
        Arrays.fill(last,-1);
        int j=m-1;
        for(int i=n-1;i>=0 && j>=0;i--){
            if(word1.charAt(i)==word2.charAt(j)){
                last[j]=i;
                j--;
            }
        }
        j=0;
        int[] ans=new int[m];
        boolean mis=true;
        for(int i=0;i<n && j<m;i++){
            if(word1.charAt(i)==word2.charAt(j)|| (mis && (j==m-1 || i+1<=last[j+1]))){
                if(word1.charAt(i)!=word2.charAt(j)){
                    mis=false;
                }
                ans[j]=i;
                j++;
            }
        }
        if(j!=m){
            return new int[0];
        }
        return ans;


           }
}