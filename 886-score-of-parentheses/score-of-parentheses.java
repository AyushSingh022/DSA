class Solution {
    public int scoreOfParentheses(String s) {
        int score=0;
        int bracket=0;
        for(int  i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                bracket++;
            }
            else{
                bracket--;
                if(s.charAt(i-1)=='('){
                    score+=1<<bracket;
                }
            }
        }
        return score;
        
    }
}