class Solution {
    int count = 0;
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;i++){
            for(int j= 0;j<m;j++){
                if(grid[i][j] == 1){
                    dfs(i,j,grid);
                    return count;
                }
            }
        }
        return -1;
    }

    public void dfs(int i, int j,int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int []xArr ={-1,0,+1,0};
        int []yArr ={0,+1,0,-1};
        if(i<0 || i>=n || j<0 || j>=m){
            count++;
            return;
        }
        if(grid[i][j] == 0){
            count++;
            return;
        }
        if(grid[i][j] == -1){
            return;
        }
        grid[i][j] = -1;
        for(int k = 0;k<4;k++){
            int xCordinate = i + xArr[k];
            int yCordinate = j + yArr[k];
            dfs(xCordinate,yCordinate,grid);
        }
    }
}