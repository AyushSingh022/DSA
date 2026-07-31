class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int[] freq=new int[26];
        for(int ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        int ans=0;
        Arrays.sort(freq);
        for(int i=25;i>=0 && freq[i]>0;i--){
            ans+=freq[i]*((25-i)/8+1);
        }
        return ans;
        
    }
}