class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         HashMap<Integer,Integer>mp=new HashMap<>();
         for(int num:nums1){
            mp.put(num,mp.getOrDefault(num,0)+1);
         }
         List<Integer>ans=new ArrayList<>();
         for(int num:nums2){
            if(mp.containsKey(num) && mp.get(num)>0){
                ans.add(num);
                mp.put(num,mp.get(num)-1);
            }
         }
         int arr[]=new int[ans.size()];
         for(int i=0;i<arr.length;i++){
            arr[i]=ans.get(i);
         }
         return arr;
    }
}