class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int cnt=0;
        for(char c:s.toCharArray()){
            if(c=='1'){
                cnt++;
            }
        }
        String t="1"+s+"1";
        ArrayList<Character> ans=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(char c:t.toCharArray()){
            if(ans.isEmpty() || ans.get(ans.size()-1)!=c){
                ans.add(c);
                arr.add(1);
            }
            else{
                arr.set(arr.size()-1,arr.get(arr.size()-1)+1);
            }
        }
        int best=0;
        for(int i=1;i+1<ans.size();i++){
            if(ans.get(i)=='1' && ans.get(i-1)=='0' && ans.get(i+1)=='0'){
                best=Math.max(best,arr.get(i-1)+arr.get(i+1));
            }
        }
        return cnt+best;
        
    }
}