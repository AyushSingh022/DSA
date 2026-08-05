class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:invocations){
            int u=edge[0];
            int v=edge[1];
            adj[u].add(v);
        }
        boolean s[]=new boolean[n];
        s[k]=true;
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(k);
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:adj[u]){
                if(!s[v]){
                    s[v]=true;
                    q.offer(v);
                }
            }
        }
        for(int[] edge:invocations){
           int u=edge[0];
           int v=edge[1];
           if(!s[u] && s[v]){
            List<Integer> a=new ArrayList<>();
            for(int i=0;i<n;i++){
                a.add(i);
            }
            return a;
           }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!s[i]){
                res.add(i);
            }
        }
        return res;
        
    }
}