class Solution {
    public String reverseWords(String s) {
        String[] str=s.trim().split("\\s+");
        String ans="";
        for(int i=str.length-1;i>=0;i--){
            if(i==0){
                ans+=str[i];
                break;
            }
             ans+=str[i]+" ";
        }
        return ans;
        
    }
}