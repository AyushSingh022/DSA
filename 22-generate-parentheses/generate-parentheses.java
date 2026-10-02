class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        back(n,0,0,new StringBuilder(),ans);
        return ans;
    }
    void back(int n,int open,int close,StringBuilder p,List<String> ans){
        if(p.length()==2*n){
            ans.add(p.toString());
                return;
            
        }
        if(open<n){
            p.append('(');
            back(n,open+1,close,p,ans);
            p.deleteCharAt(p.length()-1);
        }
        if(close<open){
            p.append(')');
            back(n,open,close+1,p,ans);
            p.deleteCharAt(p.length()-1);
        }
    }
}