class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> al = new ArrayList<>();
        int n = intervals.length;
        if(n == 0){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }
        for(int i = 0;i<n;i++){
            int s1 = intervals[i][0];
            int e1 = intervals[i][1];
            int s2 = newInterval[0];
            int e2 = newInterval[1];
            if(e1 < s2){
                List<Integer> temp = new ArrayList<>();
                temp.add(s1);
                temp.add(e1);
                al.add(temp);
            }
            else if(s1 > e2){
                List<Integer> temp = new ArrayList<>();
                temp.add(s2);
                temp.add(e2);
                al.add(temp);
                for(int j = i;j<n;j++){
                    List<Integer> tempX = new ArrayList<>();
                    tempX.add(intervals[j][0]);
                    tempX.add(intervals[j][1]);
                    al.add(tempX);
                }
                int solSize = al.size();
                int [][] sol = new int[solSize][2];
                for(int k = 0;k<solSize;k++){
                    sol[k][0] = al.get(k).get(0);
                    sol[k][1] = al.get(k).get(1);
                }
                return sol;
            }
            else{
                newInterval[0] = Math.min(s1,s2);
                newInterval[1] = Math.max(e1,e2);
            }

        }
        int solSize = al.size();
        int [][] sol = new int[solSize+1][2];
        for(int i = 0;i<solSize;i++){
            sol[i][0] = al.get(i).get(0);
            sol[i][1] = al.get(i).get(1);
        }
        sol[solSize][0] = newInterval[0];
        sol[solSize][1] = newInterval[1];
        return sol;
    }
}