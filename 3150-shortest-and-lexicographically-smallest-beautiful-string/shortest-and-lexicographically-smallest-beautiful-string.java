class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans="";
        int x=0;
        int one=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                one++;
            }
        while(one>k){
            if(s.charAt(x)=='1'){
                one--;
            }
            x++;
        }
        while(one==k && s.charAt(x)=='0'){
            x++;
        }
        if(one==k){
            String answer=s.substring(x,i+1);
            if(ans.isEmpty() || answer.length()<ans.length() || (answer.length()==ans.length() && answer.compareTo(ans)<0)){
                ans=answer;
            }
        }
    }
        return ans;
        
    }
}