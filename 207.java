class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList();            
        }
        
        for(int[] pre: prerequisites){
            graph[pre[0]].add(pre[1]);
        }
        
        Queue<Integer> noPreq = new LinkedList();
        List<Integer> result = new ArrayList();
        
        for(int i=0;i<n;i++){
            if(graph[i].size() == 0){
                noPreq.offer(i);
            }
        }
        
        while(noPreq.isEmpty() == false){
            int node = noPreq.poll();
            for(int i=0;i<n;i++){
                if(graph[i].size()>0){
                    graph[i].remove(Integer.valueOf(node));
                    if(graph[i].size() == 0){
                        noPreq.offer(i);
                    }
                }                
            }
            result.add(node);            
        }
        
        return result.size() == n;
    }
}