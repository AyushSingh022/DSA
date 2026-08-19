class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int[] s:reservedSeats){
            int x=s[0];
            int y=s[1];
            if(y>=2 && y>=0){
                mp.put(x,mp.getOrDefault(x,0)|(1<<y));
            }
        }
        int ans=2*(n-mp.size());
        int left=(1<<2 )|(1<<3)|(1<<4)|(1<<5);
        int middle=(1<<4)|(1<<5)|(1<<6)|(1<<7);
        int right=(1<<6)|(1<<7)|(1<<8)|(1<<9);
        for(int m:mp.values()){
            boolean canleft=(m&left)==0;
            boolean canmiddle=(m&middle)==0;
            boolean canright=(m&right)==0;
            if(canleft && canright){
                ans+=2;
            }
            else if(canleft|| canmiddle || canright){
                ans+=1;
            }
        }
        return ans;
    }
}