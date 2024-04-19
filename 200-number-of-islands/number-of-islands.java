class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    ans++;
                    goToAllFourDirection(i,j,grid);
                }
            }
        }
        return ans;
    }

    public void goToAllFourDirection(int i, int j, char [][] matrix){
        if(i>0){ //up
            if(matrix[i-1][j] == '1'){
                matrix[i-1][j] = '0';
                goToAllFourDirection(i-1,j,matrix);
            }
        }
        if(i<matrix.length-1){ //down
            if(matrix[i+1][j] == '1'){
                matrix[i+1][j] = '0';
                goToAllFourDirection(i+1,j,matrix);
            }
        }
        if(j<matrix[0].length-1){ //right
            if(matrix[i][j+1] == '1'){
                matrix[i][j+1] = '0';
                goToAllFourDirection(i,j+1,matrix);
            }
        }
        if(j>0){ //left
            if(matrix[i][j-1] == '1'){
                matrix[i][j-1] = '0';
                goToAllFourDirection(i,j-1,matrix);
            }
        }
    }
}