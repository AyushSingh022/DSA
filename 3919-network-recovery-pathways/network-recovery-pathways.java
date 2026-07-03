class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n=online.length;
        ArrayList<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        int[] indegree=new int[n];
        int max=0;
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
        
        adj[u].add(new int[]{v,w});
        indegree[v]++;
        max=Math.max(max,w);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int u=q.poll();
            topo.add(u);
            for(int[] e:adj[u]){
                int v=e[0];
                indegree[v]--;
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }
        long l=0;
        long h=max;
        int ans=-1;
        while(l<=h){
            long mid=l+(h-l)/2;
            if(check(mid,adj,topo,online,k,n)){
                ans=(int) mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return ans;
    }
     static  boolean check(long mid, List<int[]>[] adj, List<Integer> topo,
                          boolean[] online, long k, int n) {

        long INF = (long) 1e18;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == INF) continue;

            if (u != 0 && u != n - 1 && !online[u]) continue;

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int w = edge[1];

                if (w < mid) continue;
                if (v != n - 1 && !online[v]) continue;

                dist[v] = Math.min(dist[v], dist[u] + w);
            }
        }

        return dist[n - 1] <= k;
    }
}