class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;i++){
            for(int j= 0;j<m;j++){
                if(grid[i][j] == 1){
                    return dfs(i,j,grid);
                }
            }
        }
        return -1;
    }

    public int dfs(int i, int j,int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int []xArr ={-1,0,+1,0};
        int []yArr ={0,+1,0,-1};
        if(i<0 || i>=n || j<0 || j>=m){
            return 1;
        }
        if(grid[i][j] == 0){
            return 1;
        }
        if(grid[i][j] == -1){
            return 0;
        }
        grid[i][j] = -1;
        int ans = 0;
        for(int k = 0;k<4;k++){
            int xCordinate = i + xArr[k];
            int yCordinate = j + yArr[k];
            ans = ans + dfs(xCordinate,yCordinate,grid);
        }
        return ans;
    }
}