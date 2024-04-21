class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        int vis[] = new int[n];
        for(int i = 0;i<n;i++){
            List<Integer> temp = new ArrayList<>();
            graph.add(temp);
        }
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(source,graph,vis);
        if(vis[destination] == 1){
            return true;
        }
        return false;
    }
    public void dfs(int source,List<List<Integer>> graph,int [] vis){
        if(vis[source] == 1){
            return;
        }
        vis[source] = 1;
        List<Integer> connected = graph.get(source);
        for(int i = 0;i<connected.size();i++){
            dfs(connected.get(i),graph,vis);
        }
    }
}