class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] res=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=arr[i];
        }
        Arrays.sort(arr);
        int rank=1;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int ele:arr){
            if(!mp.containsKey(ele)){
                mp.put(ele,rank++);
            }
        }
        for(int i=0;i<arr.length;i++){
            res[i]=mp.get(res[i]);
        }
        return res;
        
    }
}