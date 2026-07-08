class Solution {
    final int mod=1000000007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length();
        int q=queries.length;
        long[] sum=new long[n+1];
        long[] no=new long[n+1];
        long[] cnt=new long[n+1];
        long[] p=new long[n+1];
        p[0]=1;
        for(int i=1;i<=n;i++){
            p[i]=(p[i-1]*10)%mod;
        }
        char[] ch=s.toCharArray();
        long cn=0;
        long ccnt=0;
        for(int i=0;i<n;i++){
            int x=ch[i]-'0';
            sum[i+1]=sum[i]+x;
            if(x>0){
                cn=(cn*10+x)%mod;
                ccnt++;
            }
            no[i+1]=cn;
            cnt[i+1]=ccnt;
        }
        int[] res=new int[q];
        for(int i=0;i<q;i++){
            int  l=queries[i][0];
            int r=queries[i][1];
            long ss=sum[r+1]-sum[l];
            int  len=(int)(cnt[r+1]-cnt[l]);
            long val=(no[r+1]-(no[l]*p[len])%mod+mod)%mod;
            res[i]=(int)((ss%mod*val)%mod);
        }
        return res;
        
    }
}