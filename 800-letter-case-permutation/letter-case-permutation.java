class Solution {
    ArrayList<String>ans=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char[] arr=s.toCharArray();
        backtrack(arr,0);
        return ans;
    }
    void backtrack(char[] arr,int index){
        if(index==arr.length){
            ans.add(new String(arr));
            return;
        }
        if(Character.isDigit(arr[index])){
            backtrack(arr,index+1);
            return;
        }
        arr[index]=Character.toLowerCase(arr[index]);
        backtrack(arr,index+1);

        arr[index]=Character.toUpperCase(arr[index]);
        backtrack(arr,index+1);

    }
}