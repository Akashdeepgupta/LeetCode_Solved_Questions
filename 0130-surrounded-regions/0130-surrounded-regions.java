class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int [][] vis = new int[n][m];
        //traverse to all boundaries

        //1st row
        for(int i = 0;i<m;i++){
            if(board[0][i] == 'O' && vis[0][i] == 0 ){
                dfs(board,0,i,vis);
            }
        }

        //last row
        for(int i = 0;i<m;i++){
            if(board[n-1][i] == 'O'  && vis[n-1][i] == 0 ){
                dfs(board,n-1,i,vis);
            }
        }

        //1st column
        for(int i = 0;i<n;i++){
            if(board[i][0] == 'O'  && vis[i][0] == 0 ){
                dfs(board,i,0,vis);
            }
        }

        //last column
        for(int i = 0;i<n;i++){
            if(board[i][m-1] == 'O'  && vis[i][m-1] == 0 ){
                dfs(board,i,m-1,vis);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == 'O'  && vis[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, int x, int y, int[][]vis){
        int n = board.length;
        int m = board[0].length;
        vis[x][y] = 1;
        int [] row = {-1,0,1,0};
        int [] col = {0,1,0,-1};
        for(int i = 0;i<4;i++){
            int nrow = x+row[i];
            int ncol = y+col[i];
            if( nrow>=0 && nrow<n && ncol>=0 && ncol<m && board[nrow][ncol]=='O' && vis[nrow][ncol]==0 ){
                dfs(board,nrow,ncol,vis);
            }
        }
    }
}


        //            x-1,y
        // x,y-1 <-  x,y -> x,y+1
        //          x+1,y