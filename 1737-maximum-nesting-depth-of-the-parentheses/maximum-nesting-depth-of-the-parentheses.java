class Solution {
    public int maxDepth(String s) {
        int max=0;
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                st.pop();
            }
            if(max<st.size()){
                max=st.size();
            }
        }
        return max;
        
    }
}