class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List <Integer> list = new ArrayList<Integer>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(SmallestInRow(matrix,i,j) && GreatestInColumn(matrix,i,j))
                {
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }
    
    
    static boolean SmallestInRow(int [][]arr, int x, int y)
    {
        int q = arr[x][y];
        for (int i = 0; i < arr[0].length; i++) {
            if(q > arr[x][i])
            { 
                return false;
            }
        }
        return  true;
    }

    static boolean GreatestInColumn(int [][]arr, int x, int y)
    {
        int q = arr[x][y];
        for (int i = 0; i < arr.length; i++) {
            if(q < arr[i][y])
            {
                return false;
            }
        }
        return  true;
    }
    
}