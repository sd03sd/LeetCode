class Graph {

    public List<List<int[]>>adj;
    public int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v,w});
        }
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];

        adj.get(u).add(new int[]{v,w});
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{node1, 0});
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            if(visited[u]){
                continue;
            }
            visited[u] = true;
            if(u == node2){
                return d;
            }
            for(int[] e : adj.get(u)){
                int v = e[0];
                int w = e[1];
                if(!visited[v]){
                    pq.offer(new int[]{v, d+w});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */