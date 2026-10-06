class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int cnt=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                open++;
            }
            else{
                if(open>0){
                    open--;
                }
                else{
                    cnt++;
                }
            }
        }
        return cnt+open;
        
    }
}