class Solution {
    int[] dx={1,-1,0,0};
    int[] dy={0,0,-1,1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        
        int n=grid.size();
        int m=grid.get(0).size();
        int[][] max=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(max[i],-1);
        }
        int inital=health-grid.get(0).get(0);
        if(inital<0){
            return false;
        }
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{inital,0,0});
        max[0][0]=inital;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int currh=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(r==n-1 && c==m-1){
                return true;
            }
            for(int d=0;d<4;d++){
                int nr=r+dx[d];
                int nc=c+dy[d];
                if(nr<0 || nc<0 || nr>=n || nc>=m){
                    continue;
                }
                    int ren=currh-grid.get(nr).get(nc);
                    if(ren<=0){
                        continue;
                    }
                    if(ren<=max[nr][nc]){
                        continue;
                    }
                    max[nr][nc]=ren;
                    q.offer(new int[] {ren,nr,nc});
                
            }
        }
        return false;

    }
}