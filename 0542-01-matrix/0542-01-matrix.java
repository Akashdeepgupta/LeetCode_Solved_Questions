class Pair{
    int x;
    int y;
    int dist;
    Pair(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int [][] vis = new int[n][m];
        int [][] distance = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        /*
        inserting the elements in the queue which are source(the element which are 0 itself has dist = 0 that
         elements will be storing in the queue first then we will do multisource BFS)
        */ 
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 0){
                    Pair p = new Pair(i,j,0);
                    q.offer(p);
                    vis[i][j] = 1;
                }
            }
        }

        // traverse over the queue 
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.dist;
            distance[x][y] = dist;
            //up
            if(x > 0){
                if(vis[x-1][y] == 0){
                    Pair temp = new Pair(x-1,y,dist+1);
                    q.offer(temp);
                    vis[x-1][y] = 1;
                }
            }

            //down
            if(x < n-1){
                if(vis[x+1][y] == 0){
                    Pair temp = new Pair(x+1,y,dist+1);
                    q.offer(temp);
                    vis[x+1][y] = 1;
                }
            }

            //left
            if(y > 0){
                if(vis[x][y-1] == 0){
                    Pair temp = new Pair(x,y-1,dist+1);
                    q.offer(temp);
                    vis[x][y-1] = 1;
                }
            }

            //right
            if(y<m-1){
                if(vis[x][y+1] == 0){
                    Pair temp = new Pair(x,y+1,dist+1);
                    q.offer(temp);
                    vis[x][y+1] = 1;
                }
            }
        }
        return distance;
    }
}