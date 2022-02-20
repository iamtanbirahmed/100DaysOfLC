class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList();
        }
        for(int[] pre: prerequisites){
            graph[pre[0]].add(pre[1]);
        }
        
        Queue<Integer> noPre = new LinkedList();
        Queue<Integer> result = new LinkedList();
        
        for(int i=0;i<n;i++){
            if(graph[i].size() ==0){
                noPre.offer(i);
            }
        }
        
        while(noPre.isEmpty() == false){
            Integer node = noPre.poll();
            for(int i=0;i<n;i++){
                if(graph[i].size()>=1){
                    graph[i].remove(node);
                    if(graph[i].size() == 0){
                        noPre.offer(i);
                    }
                }                    
            }
            result.offer(node);
        }
        if(result.size()!=n) return new int[0];
        int[] resultArray = new int[result.size()];
        int i=0;;
        while(result.isEmpty() == false){
            resultArray[i] = result.poll();
            i++;
        }
        return resultArray;
    }
}