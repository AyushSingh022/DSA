class Solution {
    public boolean checkValidString(String str) {
        int s=0;
        int e=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                s++;
                e++;
            }
            else if(str.charAt(i)==')'){
                if(s>0){
                    s--;
                }
                e--;
            }
            else{
                if(s>0){
                    s--;
                }
                e++;
            }
            if(e<0){
                return false;
            }
        }
        return s==0;
        
    }
}