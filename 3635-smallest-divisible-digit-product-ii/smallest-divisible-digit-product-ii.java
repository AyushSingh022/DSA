class Solution {
    int[] prime=new int[]{2,3,5,7};
    int max=prime[prime.length-1];
    public String smallestNumber(String num, long t) {
        int primecount[]=new int[max+1];
        int nums=num.length();
        int min=0;
        int first=0;
        for(int p:prime){
            while(t%p==0){
                t/=p;
                primecount[p]++;
            }
        }
        if(t!=1){
            return "-1";
        }
        min=get(primecount);
        if(nums<min){
            return build(primecount,min,new char[min]);
        }
        char[] res=new char[nums+1];
        for(int i=0;first<nums && (res[++i]=num.charAt(first))!='0';first++){
            log(primecount,res[i],-1);
        }
        if(get(primecount)==0){
            if(first==nums){
                return num;
            }
        Arrays.fill(res,++first,res.length,'1');
        return new String(res,1,nums);
        }

         for(int j=nums-1,k=Math.min(first,j);k>=0;k--) {
            for (log(primecount, res[k+1],1); ++res[k+1]<='9';log(primecount, res[k+1],1)) {
                log(primecount,res[k+1],-1);
                if (get(primecount)<= j-k) {
                    return build(primecount,j-k, res);
                }
            }
        }
        return build(primecount,res.length,res);
    }
    void log(int[] primecount,int num,int value){
        if(num<'2'){
            return;
        }
        if(num=='9'){
                primecount[3]+=value<<1;
        }
        else if(num=='4'){
            primecount[2]+=value<<1;
        }
        else if(num=='8'){
            primecount[2]+=value*3;
        }
        else if(num=='6'){
            primecount[2]+=value;
            primecount[3]+=value;
        }
        else{
            primecount[num-'0']+=value;
        }
    }
    String build(int[] p,int t,char[] res){
        int index=res.length;
        while(p[3]>1){
            p[3]-=2;
            res[--index]='9';
        }
        while(p[2]>2){
            p[2]-=3;
            res[--index]='8';
        }
        while(p[7]-->0){
            res[--index]='7';

        }
        if(p[2]>0 && p[3]>0){
            res[--index]='6';
            p[2]--;
            p[3]--;
        }
        while(p[5]-->0){
            res[--index]='5';
        }
        while(p[2]>1){
            p[2]-=2;
            res[--index]='4';
        }
        while(p[3]>0){
            p[3]--;
            res[--index]='3';
        }
        while(p[2]>0){
            p[2]--;
            res[--index]='2';
        }
        while(index+t!=res.length){
            res[--index]='1';
        }
        return t==res.length ? new String(res) :new String(res,1,res.length-1);
    }
    int get(int[] p){
        int cnt1=Math.max(0,p[2]);
        int cnt2=Math.max(0,p[3]);
        int cnt3=(cnt2 &1 )+(cnt1%3);
        return (cnt2>>1)+(cnt1/3)+Math.max(0,p[7])+Math.max(0,p[5])+(cnt3==3?2:cnt3>0 ?1:0);
    }
}