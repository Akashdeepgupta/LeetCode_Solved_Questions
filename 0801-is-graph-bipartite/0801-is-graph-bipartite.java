class Solution {
    public boolean isBipartite(int[][] graph) {
        //create Adjacency list
        ArrayList<ArrayList<Integer>> AdjList = new ArrayList<>();
        int n = graph.length;
        for(int i = 0;i<n;i++){
            ArrayList<Integer> al = new ArrayList<>();
            AdjList.add(al);

            for(int j = 0;j<graph[i].length;j++){
                AdjList.get(i).add(graph[i][j]);
            }
        }
        int [] color = new int[n];
        for(int i = 0;i<color.length;i++){
            color[i] = -1;
        }

        for(int i = 0;i<n;i++){
            if(color[i] == -1){
                if(check(i,AdjList,color) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(int src, ArrayList<ArrayList<Integer>> graph , int [] color){
        color[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            for(int nbr : graph.get(node)){
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