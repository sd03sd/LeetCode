class Solution {
    static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph,int[][] prerequisites){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<prerequisites.length; i++){
            int src = prerequisites[i][0];
            int dest = prerequisites[i][1];

            Edge e = new Edge(src, dest);
            graph[src].add(e);
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        createGraph(graph, prerequisites);

        int[] indegree = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            for(Edge e : graph[i]){
                indegree[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            list.add(curr);

            for(Edge e : graph[curr]){
                indegree[e.dest]--;
                if(indegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        if (list.size() != numCourses) {
            return new int[0]; 
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


        return arr;
    }
}