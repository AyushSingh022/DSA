class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt=new int[26];
        for(char ch:s.toCharArray()){
            cnt[ch-'a']++;
        }
        int n=s.length();
        int x=0;
        while(x<n && cnt[target.charAt(x)-'a']>0){
            cnt[target.charAt(x)-'a']--;
            x++;
        }
        int s1=Math.min(x,n-1);
        for(int i=s1;i>=0;i--){
            if(i<x){
                cnt[target.charAt(i)-'a']++;
            }
            int ans=-1;
            for(int c=target.charAt(i)-'a'+1;c<26;c++){
                if(cnt[c]>0){
                    ans=c;
                    break;
                }
            }
            if(ans!=-1){
                cnt[ans]--;
                StringBuilder aa=new StringBuilder(target.substring(0,i));
                aa.append((char)('a'+ans));
                for(int c=0;c<26;c++){
                    while(cnt[c]>0){
                        aa.append((char)('a'+c));
                        cnt[c]--;
                    }
                }
                return aa.toString();
            }
        }
        return "";
    }
}