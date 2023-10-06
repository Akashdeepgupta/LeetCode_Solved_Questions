class pair{
    int x;
    int y;
    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int freshCount = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    freshCount++;
                }
                else if( grid[i][j] == 2 ){
                    q.add(new pair(i,j));
                }
            }
        }
        if(freshCount == 0){
            return 0;
        }
        int [] row = {-1,0,+1,0};
        int [] col = {0,+1,0,-1};
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int i = 1;i<=size;i++){
                pair pr = q.poll();
                //visit all 4 directions
                for(int j =0;j<4;j++){
                    int nx = pr.x+row[j];
                    int ny = pr.y+col[j];
                    if(nx>=0 && nx<n && ny>=0 && ny<m){
                        if(grid[nx][ny] == 1){
                            freshCount--;
                            grid[nx][ny] = 2;
                            q.add(new pair(nx,ny));
                        }
                    }
                }
            }
            //
        }
        if(freshCount == 0){
            return time-1;
        }
        return -1;
    }
}