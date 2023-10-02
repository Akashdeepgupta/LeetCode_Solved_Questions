class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int [] color = new int[n];
        for(int i = 0;i<color.length;i++){
            color[i] = -1;
        }

        for(int i = 0;i<n;i++){
            if(color[i] == -1){
                if(check(i,graph,color) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(int src, int[][] graph , int [] color){
        color[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            for(int nbr : graph[node] ){
                if(color[nbr] == -1){
                    color[nbr] = 1-color[node];
                    q.add(nbr);
                }
                else if(color[nbr] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}